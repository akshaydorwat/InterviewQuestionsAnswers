/*
  Given an n x n matrix, where every row and column is sorted in non-decreasing order. Find the kth smallest element in the given 2D array.
 */


struct heapNode
{
  int r;
  int c;
  int data;
};


void min_heapify(struct heapNode *heap, int n, int size)
{
  int left = n*2 + 1;
  int right = n*2 + 2;
  int smallest = n;
  
  if(left < size && heap[left] < heap[n]){
    smallest = left;
  }

  if(right < size && heap[right] < heap[n]){
    smallest = right;
  }

  if(smallest != n){
    temp = heap[smallest];
    heap[smallest] = heap[n];
    heap[n] = temp;

    min_heapify(heap, smallest, size);
  }
}


void build_heap(struct heapNode *heap, int n, int size){
  int i=0;

  for(i=n/2; i>=0; i--){
    min_heapify(heap, i, size);
  }
}



int find_point(int arr[], int start, int end){

  if(start >= end){
    return -1;
  }

  
  int mid = (start + end) / 2;

  if(arr[mid] > arr[mid] - 1 && arr[mid] < arr[mid +1]){
    return arr[mid];
  }


  if(arr[mid] < arr[mid+1]){
    return find_point(arr, mid + 1, end);
  }else{
    return find_point(arr, start, mid -1);
  }
  
}
