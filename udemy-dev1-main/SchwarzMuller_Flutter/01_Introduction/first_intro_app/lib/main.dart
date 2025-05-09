import 'package:flutter/material.dart';
import 'package:first_intro_app/gradient_container.dart';

void main() {
  runApp(const MaterialApp(
    home: Scaffold(
        body: GradientContainer([
      Color.fromARGB(252, 31, 251, 192),
      Color.fromARGB(255, 101, 206, 69)
    ])),
  ));
}
