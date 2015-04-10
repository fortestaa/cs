//
//  155	Min Stack.cpp
//

#include <stdio.h>
#include <stack>
#include <iostream>
using namespace std;

class MinStack {
private:
    stack<int> elements;
    stack<int> mins;
    
public:
    void push(int x) {
        elements.push(x);
        if (mins.empty() || x <= mins.top()) {
            mins.push(x);
        }
    }
    
    void pop() {
        if (elements.empty()) {
            return;
        }
        if (elements.top() == mins.top()) {
            mins.pop();
        }
        elements.pop();
    }
    
    int top() {
        return elements.top();
    }
    
    int getMin() {
        return mins.top();
    }
};

/*int main(int argc, const char * argv[]) {
    // insert code here...
    MinStack ms;
    ms.push(-3);
    cout << ms.getMin() << endl;
    
    
    return 0;
}*/
