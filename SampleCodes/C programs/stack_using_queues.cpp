#include <iostream>
#include <queue>

using namespce std;
class stack{
  queue<int> pushQ;
  queue<int> popQ;
  queue<int> tempQ;
  
  int temp;
  
  void push(int data){
    
    pushQ.push(data);
    while(!popQ.empty()){
      temp = popQ.front();
      pushQ.push(temp);
      popQ.pop();
    }

    tempQ = pushQ;
    pushQ = popQ;
    popQ = tempQ;
  }
  
  int pop(){
    int temp = -9999;
    
    if(!popQ.empty()){
      temp = popQ.front();
      popQ.pop();
    }

    return temp;
  }
  
}
int main(int argc, char *argv[])
{
  
  return 0;
}

