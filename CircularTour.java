public class CircularTour {
    static int findStartingPoint(int[] petrol, int[] distance) {
        int totalSurplus = 0; // Total excess petrol
        int currentSurplus = 0; // Current petrol balance
        int startIndex = 0; // Potential starting index

        for (int i = 0; i < petrol.length; i++) {
            int balance = petrol[i] - distance[i]; // Net fuel balance at this pump
            totalSurplus += balance;
            currentSurplus += balance;

            // If fuel deficit occurs, reset the start index
            if (currentSurplus < 0) {
                startIndex = i + 1;
                currentSurplus = 0;
            }
        }

        // If totalSurplus is negative, completing the tour is not possible
        return (totalSurplus >= 0) ? startIndex : -1;
    }

    public static void main(String[] args) {
        int[] petrol = { 4, 6, 7, 4 };
        int[] distance = { 6, 5, 3, 5 };

        int start = findStartingPoint(petrol, distance);
        System.out.println((start != -1) ? "Start at petrol pump: " + start : "No possible tour");
        // Output: Start at petrol pump: 1
    }
}
