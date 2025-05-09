import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

void main() {
  runApp(const MyApp(
      [Color.fromARGB(255, 223, 207, 71), Color.fromARGB(255, 245, 60, 60)]));
}

class MyApp extends StatelessWidget {
  const MyApp(this.colors, {super.key});
  final List<Color> colors;
  // This widget is the root of your application.
  void rollDice() {}
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        home: Scaffold(
      body: Container(
          decoration: BoxDecoration(
            gradient: LinearGradient(
              colors: colors,
              begin: Alignment.bottomCenter,
              end: Alignment.topLeft,
            ),
          ),
          child: Center(
              child: Column(
            // mainAxisAlignment: MainAxisAlignment.center,
            mainAxisSize: MainAxisSize.min,
            // crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Image.asset(
                "assets/images/dice-2.png",
                width: 200,
              ),
              const Text("Hello World"),
              TextButton(
                  onPressed: rollDice,
                  style: TextButton.styleFrom(
                      padding: const EdgeInsets.all(20),
                      foregroundColor: Colors.red,
                      backgroundColor: Colors.black,
                      textStyle: const TextStyle(
                        fontSize: 28,
                      )),
                  child: const Text(
                    "Roll the Dice",
                  ))
            ],
          ))),
    ));
  }
}
