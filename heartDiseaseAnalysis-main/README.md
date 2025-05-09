## Intro :- 
	- The main purpose of designing this system is to predict the risk of heart disease in a patient and trying to. we have used Various Machine Learning algorithms to evaluate and train the model, such as Logistic Regression, Decision Tree Classifier, Random Forest Classifier and Support Vector Machine (SVM). The main objective of this project is not just predicting the risk of a heart attack but also analysing and putting some results which might help us to determine the risk factors based on the patient’s vital signs and to extract some insights which helps us to understand their working principle.

	- In this project, We have used Machine Learning to predict whether a person is suffering from a heart disease or not. 
### Steps which were involved along the project.
#### 1. Data Collection.
#### 2. Data Preperation(Importing, Exploratory Data Analysis), After importing the data we have used some basic pandas fucntions to get to know more about the data, such as, Head(), tail(), Descibe() -> for statistical analysis, info(), 
#### 3. Data Exploration, we have used some plots to get an understanding of what our data is telling to us, like count of our target variable, Histogram to check whetehr the variables are normally distributed or not, Unique values present in a variable.
#### 4. Data preprocessing, here we have checked whether their are any null vlaues, outliers or unwanted values, fortunaltely we didnt have any, so after that we have created dummy variables using pd.get_dummies(), to transform our categorical variables to numerical(0/1).
#### 5. Data Transformation: this will help us to trasform the variables/ used to bring all the variables to the same scale, using StandardScaler()/Normalisation().
#### 6. Data Modelling: Before modelling our data, we are splitting our data to trian_test_split(80/20), After which we have used 2 Machine Learning algorithms, `Logistic Regression` and  `Support Vector Classifier`. I varied parameters across each model to improve their scores.
#### In the end, we can see that  `Support Vector Classifier`  has achieved better scores compared to other model.


### Requirements:-
pandas
numpy
matplotlib
seaborn
sklearn
python==3.8
