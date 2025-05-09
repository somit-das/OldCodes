import 'package:flutter/material.dart';
import 'package:first_intro_app/styled_text.dart';

var startAlignment = Alignment.topCenter;
// Alignment? startAlignment = Alignment.topCenter;
// final startAlignment = Alignment.topCenter;
// const startAlignment = Alignment.topCenter;
const endAlignment = Alignment.bottomLeft;

class GradientContainer extends StatelessWidget {
  // const GradientContainer(this.color1, this.color2, {super.key});
  const GradientContainer(this.colors, {super.key});
  // final Color color1;
  // final Color color2;
  final List<Color> colors;
  @override
  Widget build(BuildContext context) {
    return Container(
      // color: const Color.fromARGB(255, 139, 76, 76),
      decoration: BoxDecoration(
        gradient: LinearGradient(
            // colors: [color1, color2], begin: startAlignment, end: endAlignment),
            colors: colors,
            begin: startAlignment,
            end: endAlignment),
      ),
      child: const Center(child: MyText()),
    );
  }
}
