console.log(`*********************** Loop ***********************`);

let primes = [2, 3, 5];
//for-of
for (let value of primes) {
  console.log(`Value processing by for-of loop is ${value}`);
}

//for
for (let index = 0; index < primes.length; index++) {
  console.log(`Value processing by for loop is ${primes[index]}`);
}

//while
let i = 0;
while (i < primes.length) {
  console.log(`Value processing by while loop is ${primes[i]}`);
  i++;
}
