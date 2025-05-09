import 'package:flutter/material.dart';

class MyText extends StatelessWidget {
  const MyText({super.key});
  @override
  Widget build(BuildContext context) {
    return const Text(
      "hello World",
      style: TextStyle(
          color: Color.fromARGB(255, 114, 6, 201),
          fontFamily: "cursive",
          fontSize: 20),
    );
  }
}
