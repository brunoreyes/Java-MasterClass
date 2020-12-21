package com.example.game;

import java.util.ArrayList;
import java.util.List;

// interfaces are by definition abstract
public interface ISavable {
    List<String> write(); // abstracting changing ArrayList to List, making it useful to use multiple types of lists
    void read(List<String> savedValues); // abstraction can go further with making even the type ambiguous
}
