// 26. Write a program to insert an element into an array. Accept position of element to be inserted
// from user.

// Steps for this question

// we have to create a MAX size array (MAX can be anything 100, 200)
// take the size (less than MAX) from the user
// insert size number of elements into the array
// create a variable to keep count of number of elements in the array -> initially numbersCount = size
// take a position to insert the element
    // validate the position
    // if position < 0 || position > numbersCount
        // it is not possible t insert elements at this position
    // else
        // from end of array (numbersCount -1) position shift all the elements to the right by 1 position till the position variable
        // ex
        // [5,6,7,8,9,0,0]
        // element = 11
        // pos = 3
        // [5,6,7,11,8,9,0]