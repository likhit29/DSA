const student = {
    name: "karan",
    age: 14,
    class: 9,
    username: "karan@l23",
    password: "abcd",
};
let {username, password: secret} = student;
console.log(username);
console.log(secret);