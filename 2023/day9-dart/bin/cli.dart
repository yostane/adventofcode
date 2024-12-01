import 'package:cli/day9_dart.dart';
import 'package:cli/input_data.dart';

void main() {
  final inputMatrix = load(puzzleInput);
  final result = runBothSteps(inputMatrix);
  print("predictions: $result");
}
