console.log(`*********************** Function ***********************`);

/**
 * A function is a named and parameterized block of JavaScript that define once and
 * can invoke over and over again.
 * @argument value
 */
function plusOne(value) {
  return value + 1;
}
console.log(`Add 1 to number 3 ${plusOne(3)}`);

let square = function (value) {
  return value * value;
};
console.log(`Square of number 4 is ${square(4)}`);

//Arrow function
const plusTwo = (value) => value + 2;
const cube = (value) => value * value * value;
console.log(`Add 2 to number 4 ${plusTwo(4)}`);
console.log(`Cube of 4 is ${cube(4)}`);

let points = [
  { x: 1, y: 1 },
  { x: 2, y: 2 },
];

points.dist = function () {
  let firstPoint = this[0]; // this keyword refers to same object
  let secondPoint = this[1];
  let xAxisDiff = secondPoint.x - firstPoint.x;
  let yAxisDiff = secondPoint.y - firstPoint.y;
  return Math.sqrt(xAxisDiff * xAxisDiff + yAxisDiff * yAxisDiff);
};
console.log(`Distance between point 1 and point 2 is ${points.dist()}`);
