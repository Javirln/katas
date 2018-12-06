/**
 * The main idea is to count all the occuring characters(UTF-8) in string. If you have string like this aba then the
 * result should be { 'a': 2, 'b': 1 }
 * What if the string is empty ? Then the result should be empty object literal { }
 * @param string
 * @returns {*}
 */
function count(string) {
    const array = string.split("");
    if (!array.length) {
        return {};
    } else {
        return array.reduce((state, next) => {
            const clone = Object.assign({}, state);
            if (!clone.hasOwnProperty(next)) {
                clone[next] = 1;
            } else {
                clone[next] = ++clone[next];
            }
            return clone;
        }, {});
    }
}

/**
 * A Pythagorean triplet is a set of three numbers a, b, and c where a^2 + b^2 = c^2. In this Kata, you will be tasked with finding the Pythagorean triplets whose product is equal to n, the given argument to the function pythagorean_triplet.
 * Your task
 * In this Kata, you will be tasked with finding the Pythagorean triplets whose product is equal to n, the given
 * argument to the function, where 0 < n < 10000000
 *
 * Examples
 *
 * One such triple is 3, 4, 5. For this challenge, you would be given the value 60 as the argument to your function,
 * and then it would return the Pythagorean triplet in an array [3, 4, 5] which is returned in increasing order.
 * 3^2 + 4^2 = 5^2 since 9 + 16 = 25 and then their product (3 * 4 * 5) is 60.
 * @param n
 * @returns {number[]}
 */
function pythagoreanTriplet(n) {
    for (let a = 3; a < n; a++) {
        for (let b = a + 1; b < n; b++) {
            const c = Math.pow(Math.pow(a, 2) + Math.pow(b, 2), .5);
            if (a * b * c === n) return [a, b, c];
        }
    }
}

/**
 * Given a string of words, you need to find the highest scoring word.
 * Each letter of a word scores points according to it's position in the alphabet: a = 1, b = 2, c = 3 etc.
 * You need to return the highest scoring word as a string.
 * If two words score the same, return the word that appears earliest in the original string.
 * All letters will be lowercase and all inputs will be valid.
 * @param x
 * @returns {string}
 */
function high(x) {
    const alphabet = "abcdefghijklmnopqrstuvwxyz";
    const wordScores = [];
    let highScore = 0;
    let stringOut = "";
    x = x.toLowerCase();
    const xArray = x.split(" ");

    for (let wordLoop = 0; wordLoop < xArray.length; wordLoop++) {
        wordScores[wordLoop] = 0;
        for (let lettersLoop = 0; lettersLoop < xArray[wordLoop].length; lettersLoop++) {
            console.log(xArray[wordLoop][lettersLoop]);
            if (alphabet.indexOf(xArray[wordLoop][lettersLoop]) !== -1)
                wordScores[wordLoop] += alphabet.indexOf(xArray[wordLoop][lettersLoop]) + 1;
        }
        console.log(wordScores);
    }

    for (let loop = 0; loop < xArray.length; loop++)
        if (wordScores[loop] > highScore) {
            highScore = wordScores[loop];
            stringOut = xArray[loop];
        }

    return stringOut;
}


/**
 * You probably know the "like" system from Facebook and other pages. People can "like" blog posts, pictures or other
 * items. We want to create the text that should be displayed next to such an item.
 * Implement a function likes :: [String] -> String, which must take in input array, containing the names of people who
 * like an item. It must return the display text as shown in the examples:
 * likes [] // must be "no one likes this"
 * likes ["Peter"] // must be "Peter likes this"
 * likes ["Jacob", "Alex"] // must be "Jacob and Alex like this"
 * likes ["Max", "John", "Mark"] // must be "Max, John and Mark like this"
 * likes ["Alex", "Jacob", "Mark", "Max"] // must be "Alex, Jacob and 2 others like this"
 * @param names
 * @returns {string}
 */
function likes(names) {
    const length = names.length;
    if (length === 0) return 'no one likes this';
    if (length === 1) return `${names[0]} likes this`;
    if (length === 2) {
        return `${names[0]} and ${names[1]} like this`
    } else if (length === 3) {
        return `${names[0]}, ${names[1]} and ${names[2]} like this`
    } else {
        return `${names[0]}, ${names[1]} and ${length - 2} others like this`
    }
}