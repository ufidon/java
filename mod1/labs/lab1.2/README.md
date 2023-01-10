# Lab1.2: Logical operators

Write a program that 
- prompts the user to enter three integers a, b, and c, 
- determines 
  - whether a is divisible by b and c, 
  - whether a is divisible by b or c, 
  - and whether a is divisible by b or c, but not both. Hint: using xor, i.e. (a%b==0) ^ (a%c==0)

**Test scenarios and sample outputs:**

```
Please enter three integers: 10 5 6
Is 10 divisible by 5 and 6? false
Is 10 divisible by 5 or 6? true
Is 10 divisible by 5 or 6, but not both? true


Please enter three integers: 1024 64 46
Is 1024 divisible by 64 and 46? false
Is 1024 divisible by 64 or 46? true
Is 1024 divisible by 64 or 46, but not both? true
```