console.log(`*********************** Data Type ***********************`);

//Numbers (integer or real)
let intValue = 10;
let realValue = 0.1;
console.log(
  `Value of integer variable is ${intValue} and real variable is ${realValue}`
);

//String ("", '')
let doubleQuoteString = "Double Quote String";
let singleQuoteString = "Single Quote String";
console.log(
  `Value of double quote string is ${doubleQuoteString} and single quote string is ${singleQuoteString}`
);

//Boolean
let truthy = true;
let falsy = false;
console.log(`Value of truthy is ${truthy} and falsy is ${falsy}`);

//null - no value
let noValue = null;
console.log(`No value is ${noValue}`);

//undefined
let undefinedValue;
console.log(`Undefined value is ${undefinedValue}`);

//Object
let book = {
  topic: "JavaScript", // book Object Property topic
  edition: 7, // book Object Property edition
};
console.log(`Whole book object is ${book}`);
console.log(`Topic of book is ${book.topic}`);
console.log(`Edition of book is ${book["edition"]}`);

book.author = "Flanagan"; // Create new property of book object
book.contents = {}; // Create new property of book object
console.log(`Author of book is ${book["author"]}`);
console.log(
  `Content of section 1 of chapter 1 is ${book.contents?.ch01?.sec01}`
); //Conditional access property

//Array
let primes = [2, 3, 5, 7];
console.log(`First element of array is ${primes[0]}`);
console.log(`Length of array is ${primes.length}`);
primes[4] = 9; //Add new element at index 4
primes[4] = 11; //Update element at index 4
console.log(`Value of array at index 4 is ${primes[4]}`);
