// using buffer -> we can use module without importing them

const buf = Buffer.alloc(80);

for (let i = 0; i < 26; i++) {
  buf[i] = i + 97;
}

// by default UTF-8 format
console.log(buf);

console.log(buf.toString("ascii"));

// older version
const buf1 = new Buffer("node");
// size 4 bytes-> whatever size require to store string

// Assignment

// write a code to allocate 100 locations for a buffer
// and store all capital letter and display it

const buffer = Buffer.alloc(100);
for (let i = 0; i < 26; i++) {
  buffer[i] = i + 65;
}

const portion = buffer.slice(0, 27);
console.log(portion.toString());
