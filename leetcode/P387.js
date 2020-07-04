/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function (s) {
  let map = new Array(256).fill(0);
  for (let i = 0; i < s.length; i++) {
    map[s.charCodeAt(i) - "0".charCodeAt(0)]++;
  }
  for (let i = 0; i < s.length; i++) {
    if (map[s.charCodeAt(i) - "0".charCodeAt(0)] == 1) {
      return i;
    }
  }
  return -1;
};
