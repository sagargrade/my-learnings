console.log(
  `*********************** Conditional Statement ***********************`
);

let valueOne = 10;
let valueTwo = 15;

if (valueOne > valueTwo) {
  console.log(`Bigger value in ${valueOne} and ${valueTwo} is ${valueOne}`);
} else if (valueOne < valueTwo) {
  console.log(`Bigger value in ${valueOne} and ${valueTwo} is ${valueTwo}`);
} else {
  console.log(`Both values ${valueOne} and ${valueTwo} are equal`);
}

switch (valueOne) {
  case 10:
    console.log("Value one is 10");
    break;
  case 15:
    console.log("Value one is 15");
    break;
  default:
    console.log("Given Value does not satisfy the criteria");
    break;
}
