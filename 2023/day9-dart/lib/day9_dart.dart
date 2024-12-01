import 'package:collection/collection.dart';

typedef IterableMatrix = Iterable<Iterable<int>>;
typedef Prediction = (int left, int right);

IterableMatrix load(String input) {
  return input
      .split("\n")
      .map((line) => line.split(" ").map((str) => int.parse(str)));
}

Iterable<int> getDifferences(Iterable<int> numbers) {
  return IterableZip([numbers.skip(1), numbers.take(numbers.length - 1)])
      .map((e) => e[0] - e[1]);
}

bool isZeroLine(Iterable<int> numbers) {
  return numbers.every((element) => element == 0);
}

Prediction getPredictions(Iterable<int> numbers) {
  final historyLies = [numbers];
  var differences = getDifferences(numbers);
  var rightPrediction = numbers.last;
  final leftNumbers = [numbers.first];
  while (!isZeroLine(differences)) {
    rightPrediction += differences.last;
    leftNumbers.add(differences.first);
    historyLies.add(differences);
    differences = getDifferences(differences);
  }
  final leftPrediction =
      leftNumbers.reversed.reduce((value, element) => element - value);
  return (leftPrediction, rightPrediction);
}

int runStep1(IterableMatrix inputLines) {
  return inputLines.map((e) => getPredictions(e).$2).sum;
}

int runStep2(IterableMatrix inputLines) {
  return runBothSteps(inputLines).$2;
}

Prediction runBothSteps(IterableMatrix inputLines) => inputLines
    .map((e) => getPredictions(e))
    .reduce((value, element) => (value.$1 + element.$1, value.$2 + element.$2));
