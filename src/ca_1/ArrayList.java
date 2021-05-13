package ca_1;
	import java.util.Iterator;

	public class ArrayList<E> implements Iterable<E>{
		// the initial capacity of the array in case user did not specify it (i.e. user used the default constructor)
		private int capacity = 10; 
		// at the beginning, size is zero, this field can also used to refer to the current index in the ArraList
		// because the current index should point to the last element which happen to be the size in this case.
	    private int size = 0;
	    // create empty array of type Object (i.e. GENERIC!)
	    private Object[] elementData;
	    

		public ArrayList() {  // create an array with default capacity=10
			elementData = new Object[this.capacity];
	    }

		public ArrayList(int capacity) { // create the list with initial capacity specified by the user
			elementData = new Object[this.capacity];
	        this.capacity = capacity;
	    }
		


	    public void add(E e) { // add an element to the end of the list
	    	if (size == capacity) { // safety check
	        	doubleSize(); // if size exceeded capacity ---> double it!
	        }
	    	elementData[size] = e;  // assign the value received to proper index
	        size++; // increment the size to point to next position to fill next time
	    }

	    public void add(E e, int i) { // add element at specific index
	    	if (i<0 || i>size) { // if invalid index --> throw proper Exception
	    		throw new IndexOutOfBoundsException("Invalid Index");
	    	}
	    	Object[] temp;  // conditionally, create temporary container to hold existing elements
	    	if (size==capacity) {
	    		temp = new Object[capacity * 2];
	    		capacity *= 2;
	    	}
	    	else {
	    		temp = new Object[capacity];
	    	}
	    	// start copying
	    	if (i==0) { // if the user wants it at the first index
				temp[0] = e; // simply, assign it to first index then copy the rest of elements
	    		for(int j=0; j<size; j++) {
	    			temp[j+1] = elementData[j]; // j+1 because we want to fill after index 0 which is already filled
	    		}
	    		elementData = temp;
	    		size +=1; // don't forget to increase the size for future manipulation
	    		return;
	    	}
	    	// in case the index wanted is somewhere in between
	    	for(int j=0; j<i; j++) { // copy existing elements up to that index
	    		temp[j] = elementData[j];
	    	}
	    	temp[i] = e; // assign that element to the index wanted
	    	for(int j=i+1; j<size+1; j++) { // copy the rest of the elements
	    		temp[j] = elementData[j-1];
	    	} 
	    	elementData = temp;
	    	size +=1;
	    }
	    
	    void remove(E e) {  // remove by element
	        if (size == 0) { // throw exception if it's already empty
	            throw new RuntimeException("Array is already empty!");
	        }
	        for (int i=0; i<size; i++) { // loop through the array
	        	if (e.equals(elementData[i])) { // if found
	        		// shift elements to be overwritten
	        		for (int j=i; j<size-1; j++) { // size-1 because of j+1 below
	        			elementData[j] = elementData[j+1];
	        		}
	        		size -= 1; // decrement size
	        		// make a copy with capacity-1
	        		Object[] temp = new Object[capacity-1];
	            	for (int k=0; k<size; k++) { // copy elements
	            		temp[k] = elementData[k];
	            	}
	            	elementData = temp;
	            	capacity -= 1;
	        		return;
	        	}
	        }
	        // the program won't make it to this point if it could
	        // find the element because of the above "return" statement!
	        throw new RuntimeException("Element does not exist!");
	    }
	    
	    void remove(int i) {  // remove by index
	    	 if (size == 0) { // throw exception if it's already empty
	             throw new RuntimeException("Array is already empty!");
	         }
	    	 if (i<0 || i>size) { // if invalid index --> throw proper Exception
	     		throw new IndexOutOfBoundsException("Invalid Index");
	     	}

	        Object[] temp = new Object[capacity-1];
	        int k = 0;
	        // loop through the array, copy everything except the element on the i index
	    	for (int j=0; j<size; j++) {
	    		if (j != i) {
	    			temp[k++] = elementData[j];  // Remember, compiler reads from right to left
	    		}
	    	}
	    	elementData = temp;
	    	size -= 1;
	    	capacity -= 1;
	    }
	    

	    public void printAllElements() { // print all elements
	        for (Object o : elementData) {
	        	if (o != null) {
	        		// String.valueOf(o) vs o.toString() .. why?
	        		System.out.println(String.valueOf(o));
	        	}
	        }
	    }
	    
	    // double the size of list and copy existing elements
	    private void doubleSize() { // private .. why?
	    	Object[] temp = new Object[capacity * 2];
	    	for (int i=0; i<capacity; i++) {
	    		temp[i] = elementData[i];
	    	}
	    	// now elements are copied, overwrite the class field elementData
	    	elementData = temp;
	        // update the capacity by multiplying by 2 (it's same like capacity = capacity * 2)
	        capacity *= 2;
	    }
	    
	    
	    
	    

		@Override
		public Iterator<E> iterator() {
			// simple example of how to create an Iterator
			Iterator<E> itr = new Iterator<E>() {

	            private int currentIndex = 0;

	            @Override
	            public boolean hasNext() {
	                return currentIndex < size && elementData[currentIndex] != null;
	            }

	            @SuppressWarnings("unchecked")
				@Override
	            public E next() {
	                return (E) elementData[currentIndex++];
	            }

	            @Override
	            public void remove() {
	                throw new UnsupportedOperationException();
	            }
	        };
	        return itr;
		} 
		
		public int size() { // getter method for size
			return this.size;
		}
		
		public boolean isEmpty() { // returns True if ArrayList is empty
			return this.size == 0;
		}
		
		@SuppressWarnings("unchecked")
		E elementData(int index) {
		    return (E) elementData[index];
		}

		@SuppressWarnings("unchecked")
		public E get(int index) {
			return (E) elementData[index];
		}
//		
//		@SuppressWarnings("unchecked")
//		public E get(E index) {
//		    return (E) elementData[index];
//		}
		
		public E set(int index, E element) {
		    E oldValue = elementData(index);
		    elementData[index] = element;
		    return oldValue;
		}
		

//	    public static void main(String[] args) { // testing
//	        ArrayList<Integer> arr = new ArrayList<>();
//	        // next tow lines should throw "Array is already empty!" exception
//	        // arr.remove(new Integer(6)); 
//	        // arr.remove(0);
//
//	        for (int i=0; i<20; i++) { // fill with numbers from 0 to 19
//	        	arr.add(i); // auto-boxing
//	        }
//	        arr.remove(new Integer(6));
//	        arr.remove(5); // overloading
//	        arr.add(20); // auto-boxing
//	        arr.add(5, 5);
//	        arr.add(6, 6);
//	        arr.add(555, 21);
//	        // arr.add(111, 111);  // should throw ArrayIndexOutOfBoundsException Invalid Index
//	        arr.printAllElements();
//	        
//	        // testing Iterator
//	        Iterator<Integer> it = arr.iterator();
//	        System.out.println("Iterating the ArrayList:");
//	        while(it.hasNext()) {
//	        	System.out.print(it.next() + " ");
//	        }	
//	    }


	}


