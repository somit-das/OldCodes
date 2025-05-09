package com.sd.college.serviceimpl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sd.college.dao.AdministratorProfileDao;
import com.sd.college.dao.FacultyProfileDao;
import com.sd.college.dao.StudentProfileDao;
import com.sd.college.dao.UserDao;
import com.sd.college.entity.AdministratorProfile;
import com.sd.college.entity.FacultyProfile;
import com.sd.college.entity.StudentProfile;
import com.sd.college.entity.User;
import com.sd.college.exceptionclasses.UserNotFoundException;
import com.sd.college.responsestructure.ResponseStructure;
import com.sd.college.service.UserService;
import com.sd.college.util.AuthUser;
import com.sd.college.util.Helper;
import com.sd.college.util.Role;
import com.sd.college.util.UserStatus;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private Helper helper;

	@Autowired
	private UserDao userDao;

	@Autowired
	private StudentProfileDao studentProfileDao;

	@Autowired
	private FacultyProfileDao facultyProfileDao;

	@Autowired
	private AdministratorProfileDao administratorProfileDao;

	public ResponseEntity<?> findByUsernameAndPassword(AuthUser authUser) {
		Optional<User> optional = userDao.findByUsernameAndPassword(authUser.getUsername(), authUser.getPassword());
		if (optional.isEmpty())
			throw UserNotFoundException.builder().message("Invalid Credentials... Invalid Username or Password...")
					.build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("User Verified Successfully...").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> saveUser(User user) {
		String otp = Integer.toString(helper.generateOTP());
		boolean flag = helper.sendFirstMail(user.getName() ,user.getEmail(), otp);
		if (!flag) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value())
							.message("Enter Valid Email").body("Invaid Email Id : " + user.getEmail()).build());
		}

		String photo = "/home/som/Pictures/user-info.png";
		user.setStatus(UserStatus.IN_ACTIVE);
		user.setOtp(otp);
		user.setOtpExpiry(LocalDateTime.now().plusMinutes(5));
		user = userDao.saveUser(user);
		if (user.getRole() == Role.ADMINISTRATOR)
			administratorProfileDao.saveAdministratorProfile(
					AdministratorProfile.builder().id(user.getId()).photo(photo).user(user).build());
		else if (user.getRole() == Role.FACULTY)
			facultyProfileDao.saveFacultyProfile(FacultyProfile.builder().id(user.getId()).user(user).photo(photo)
					.officeHours(LocalTime.of(8, 30)).build());
		else
			studentProfileDao
					.saveStudentProfile(StudentProfile.builder().id(user.getId()).photo(photo).user(user).build());
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("User Saved Successfully...").body(user).build());
	}

	@Override
	public ResponseEntity<String> verifyOtp(String otp, String email) {
		Optional<User> userOptional = userDao.findUserByEmail(email);
		if(userOptional.isEmpty())
			throw UserNotFoundException.builder().message("Invalid Email").build();
		User foundUser = userOptional.get();
		if (foundUser.getOtp().equals(otp) &&
				foundUser.getOtpExpiry().isAfter(LocalDateTime.now())) {
			// Activate the user
			foundUser.setStatus(UserStatus.ACTIVE);
			foundUser.setOtp(null); // Clear the OTP after successful verification
			foundUser.setOtpExpiry(null);
			userDao.saveUser(foundUser);
			return ResponseEntity.ok("User activated successfully!");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or expired OTP.");
		}
	}

	@Override
	public ResponseEntity<?> findAllUsers() {
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("All Users Found Successfully...").body(userDao.findAllUsers()).build());
	}

	@Override
	public ResponseEntity<?> findUserById(int id) {
		Optional<User> optional = userDao.findUserById(id);
		if (optional.isEmpty())
			throw UserNotFoundException.builder().message("Invalid User Id : " + id).build();
		User user = optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("User Found Successfully...").body(user).build());
	}



}
