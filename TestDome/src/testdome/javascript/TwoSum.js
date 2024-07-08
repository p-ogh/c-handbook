/**
 * @param {number[]} numbers The array of numbers.
 * @param {number} sum The required target sum.
 * @return {number[]} An array of 2 indices. The indices of the two elements whose sum is equal to sum.
 */
function findTwoSum(numbers, sum) {
let numMap = new Map();
 for(let i = 0; i < numbers.length; i++){
  let complement = sum - numbers[i];

  if(numMap.has(complement))  {
  return [numMap.get(complement), i];
  }
  numMap.set(numbers[i], i);
 }
 return null;
  // Your code goes here
}

const indices = findTwoSum([ 3, 1, 5, 7, 5, 9 ], 10);
console.log(indices);