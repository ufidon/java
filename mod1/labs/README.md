# Lab01: Calculating local annual tax

Write a complete java program that calculates the local annual tax for residents in where they live.

1. Input:
   1. Annual income of a resident in dollar amount
   2. Age of the resident. If the age is 60 or older, this resident is regarded as a senior person.
2. Processing:
   1. The tax rate for any individual with an annual income $50,000 or less is zero. The tax rate for any individual with an annual income $100,000 or less but more than $50,000 is 7%. Other people will have a tax rate of 9%.
   2. Second, determine the senior discount. If a resident has a non-zero tax rate after Step 2.1 and is also a senior, his/her tax rate shall be reduced by 3%. 
   3. At the end, with the tax rate finalized through steps 2.1 - 2.2, calculate the tax.
3. Output: Display the following items with proper prompt.
   1. Tax amount
   2.  Tax rate
   3.  Senior discount percentage rate if applied.


**Calculation**:

- tax_amount = income * tax_rate
- senior_discount_percentage_rate = tax_rate - 0.03
- senior_tax_amount = income * senior_discount_percentage_rate



**Test scenarios and sample outputs:**

```
Please enter your income and age:
44444 20
Your tax amount is: 0.00
Your tax rate is: 0.00 %

 
Please enter your income and age:
88888 20
Your tax amount is: 6222.16
Your tax rate is: 7.00 %

 
Please enter your income and age:
222222 20
Your tax amount is: 19999.98
Your tax rate is: 9.00 %

 
Please enter your income and age:
44444 77
Your tax amount is: 0.00
Your tax rate is: 0.00 %

 
Please enter your income and age:
88888 77
Your tax amount is: 3555.52
You are qualified for senior discout. Your senior discount percentage rate is: 4.00 %

 
Please enter your income and age:
222222 77
Your tax amount is: 13333.32
You are qualified for senior discout. Your senior discount percentage rate is: 6.00 %

```