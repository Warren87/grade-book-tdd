package org.ignisoft.school;

import java.util.List;

class Calculator {
    
    private Calculator() {
        throw new UnsupportedOperationException();
    }
    
    static double calculateAvg(List<? extends Number> numbers) {
        double sum = 0;
        for (var avgForSubject : numbers) {
            sum = sum + avgForSubject.doubleValue();
        }

        return sum / numbers.size();
    }
}
