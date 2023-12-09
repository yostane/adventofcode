import 'package:cli/day9_dart.dart';
import 'package:cli/input_data.dart';
import 'package:test/test.dart';

void main() {
  test('step 1', () {
    final inputLines = load(testInput);
    expect(runStep1(inputLines), 114);
  });

  test('step 2', () {
    final inputLines = load(testInput);
    expect(runStep2(inputLines), 2);
  });
}
