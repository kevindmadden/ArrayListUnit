<h1>ArrayList versus Array</h1>
<h2>Creating an Array</h2>
<table>
<tr><th>Array</th><th>ArrayList</th></tr>
<tr>
<td>

```java
int[] arr = new int[3];
arr[0]=10;
arr[1]=11;
arr[2]=12;
//result {10, 11, 12}
``` 

</td>
<td>

 ```java
ArrayList<Integer> arrL = new ArrayList<>();
arrL.add(10);
arrL.add(11);
arrL.add(12);
//result {10, 11, 12}
```

</td>
</tr>
</table>



<h2>Printing out values stored in an array</h2>
<table>
<tr><th>Array</th><th>ArrayList</th></tr>
<tr>
<td>

```java
System.out.println(arr[0]); //prints 10
System.out.println(arr[2]); //prints 12 
``` 

</td>
<td>

 ```java
System.out.println(arrL.get(0)); //prints 10
System.out.println(arrL.get(2)); //prints 12
```

</td>
</tr>
</table>
<h2>Overwriting Values</h2>
Overwrite the value stored at index 0 with the value 20.
<table>
<tr><th>Array</th><th>ArrayList</th></tr>
<tr>
<td>

```java
arr[0] = 20;  
``` 

</td>
<td>

 ```java
arrL.set(0, 20); 
```

</td>
</tr>
</table>


<h2>Combination: Retrieve a Value and Store It</h2>
Retrieve value at index 2 and store that value at index 0.
<table>
<tr><th>Array</th><th>ArrayList</th></tr>
<tr>
<td>

```java
arr[0] = arr[2]; 
``` 

</td>
<td>

 ```java
arrL.set(arrL.get(2),0);
```

</td>
</tr>
</table>

<h2>Remove the element of the array at index 1 so that instead of the array having three elements, it now has two elements.</h2>
<table>
<tr><th>Array</th><th>ArrayList</th></tr>
<tr><td>For a normal array, you would need to make a brand new array that has one less element and then copy the values over manually. This is because once you set the length of a normal array, you aren't able to change the length.</td>
<td>For arraylist, it is considerably easier to remove elements because you can change the length of an ArrayList on the fly. To remove the element at index 1 of an ArrayList with three elements, all you have to do is call...</td>
</tr>

<tr>
<td>

```java
int[] arr2 = new int[2];
arr2[0]=arr[0];
arr2[1]=arr[2];
``` 

</td>
<td>

 ```java
arrL.remove(1);
```

</td>
</tr>
</table>
<h2>Add an additional element to the end of an array that has a value of 13.</h2>
<table>
<tr><th>Array</th><th>ArrayList</th></tr>
<tr>
<td>For normal arrays, you would need to create an entirely new array that has a length one longer than the original array. Then you would need to copy all the values over from the original array. Then you could add an additional new value in the final index of the new array.</td>
<td>For ArrayList, you can add a new value to the end fairly easily. All you would need to call is:</td>
</tr>
<tr>
<td>

```java
int[] arr3 = new int[4];
arr3[0] = arr[0];
arr3[1] = arr[1];
arr3[2] = arr[2]
arr3[3] = 13;
``` 

</td>
<td>

 ```java
arrL.add(13);
```

</td>
</tr>
</table>

<h2>Add an additional element at index 1 with a value of 20, and shift the rest of the values in the array one to the right.</h2>
<table>
<tr><th>Array</th><th>ArrayList</th></tr>
<tr>
<td>For normal arrays, you need to create a brand new array of length 4 and copy the values over accordingly.</td>
<td>For ArrayList, all you need to do is run the below line of code, and the remaining portion of the array will automatically get shifted over one to the right.</td>
</tr>

<tr>
<td>

```java
int[] arr4 = new int[4];
arr4[0] = arr[0];
arr4[1] = 20;
arr4[2] = arr[1];
arr4[3] = arr[2];
``` 

</td>
<td>

 ```java
arrL.add(20,1);
```

</td>
</tr>
</table>

<h2>Print out the number of elements in the array.</h2>

<table>
<tr><th>Array</th><th>ArrayList</th></tr>
<tr>
<td>

```java
System.out.println(arr.length);
``` 

</td>
<td>

 ```java
System.out.println(arrL.size());
```

</td>
</tr>
</table>

