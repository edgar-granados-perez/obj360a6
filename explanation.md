What Exactly is text clustering ?
- it is the categorization of data text to create a library of sorts

Salan uses news articles but this not constrained on just informatics literature

How do we separate each data set to determine the similarity between two documents?
- filtered texts? 
    - common meta data 
        - Salan refers this to as frequency
- to identify frequent words you will remove punctuation, lower case everything, and remove stop words, which are otherwise known as the most frequent words in the English language


Definitions
- corpus: a collection of docs 

Implementation Design
- a corpus will contain n amount of documents
- So the creation of the class documents is necessary

- document
    - will contain a name
    - term frequency stores how often a word appears in a document by the use of hashmap (String "word", Integer "the number of times it appears")
    - wordCount will contain the total number of words in a documents
    - In the constructor the user will input the name of the file along with the content of said file
        - this will utilize a function call preprocess

- Preprocess function
    - this function must strip, then lowercase, and replace all consecutive letter with a space character
        - This done through the use of a regex 
        - Once the regex is done then each then the data is split into terms.
        - Which then you use to initialize a new hash set which will store the word as the key and its frequency as its value
    - Traversal
        - the array, termArray, is then traversed by a for loop 
            - the for loop will first ignore all the 