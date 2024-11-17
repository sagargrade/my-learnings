console.log(`*********************** Class ***********************`);

// Declare Class
class Point {
  constructor(x, y) {
    this.x = x;
    this.y = y;
  }

  distance() {
    return Math.sqrt(this.x * this.x + this.y * this.y);
  }
}

// Create Object
const point = new Point(10, 15);
console.log(`Distance of point from 0 position is ${point.distance()}`);
