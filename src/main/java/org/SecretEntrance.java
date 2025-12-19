package org;

public class SecretEntrance {

    private static final int DIAL_SIZE = 100;
    private static final int START_POSITION = 50;

    public int solve(String input) {
        int currentPosition = START_POSITION;
        int zeroHitCount = 0;

        String[] rotations = input.trim().split("\\s+");

        for (String rotation : rotations) {
            if (rotation.isEmpty()) {
                continue; // Skip empty lines
            }

            char direction = rotation.charAt(0);
            int distance;

            try {
                distance = Integer.parseInt(rotation.substring(1));
            } catch (NumberFormatException e) {
                System.err.println("Skipping invalid rotation format: " + rotation);
                continue;
            }

            int change = (direction == 'R') ? distance : -distance;

            int nextPosition = currentPosition + change;

            currentPosition = (nextPosition % DIAL_SIZE + DIAL_SIZE) % DIAL_SIZE;

            if (currentPosition == 0) {
                zeroHitCount++;
            }
        }

        return zeroHitCount;
    }


    public int secondSolve(String input) {
        int currentPosition = START_POSITION;
        int zeroHitCount = 0;

        String[] rotations = input.trim().split("\\s+");

        for (String rotation : rotations) {
            if (rotation.isEmpty()) continue;

            char direction = rotation.charAt(0);
            int distance;

            try {
                distance = Integer.parseInt(rotation.substring(1));
            } catch (NumberFormatException e) {
                System.err.println("Skipping invalid rotation format: " + rotation);
                continue;
            }

            int clicksToFirstZero;

            if (direction == 'L') {
                clicksToFirstZero = (currentPosition == 0) ? DIAL_SIZE : currentPosition;
            } else {
                clicksToFirstZero = (currentPosition == 0) ? DIAL_SIZE : DIAL_SIZE - currentPosition;
            }

            if (distance >= clicksToFirstZero) {
                zeroHitCount++;

                int remainingDistance = distance - clicksToFirstZero;

                zeroHitCount += remainingDistance / DIAL_SIZE;
            }

            int change = (direction == 'R') ? distance : -distance;
            int nextPosition = currentPosition + change;
            currentPosition = (nextPosition % DIAL_SIZE + DIAL_SIZE) % DIAL_SIZE;
        }

        return zeroHitCount;
    }
}