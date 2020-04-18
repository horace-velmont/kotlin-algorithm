package programmers.d20200418;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.solution(new int[][]{{5, -1, 4}, {6, 3, -1}, {2, -1, 1}}, 1, 0, new String[]{"go", "go", "right", "go", "right", "go", "left", "go"}));
    }

    enum Direction {
        NORTH(0), EAST(1), SOUTH(2), WEST(3);
        int value;

        Direction(int value) {
            this.value = value;
        }

        public static Direction fromInt(int value) {
            for (Direction d : Direction.values())
                if (d.value == value) return d;
            return null;
        }
    }

    public int solution(int[][] office, int r, int c, String[] move) {
        int answer = clean(office, r, c);
        Direction direction = Direction.NORTH;
        int rCurr = r;
        int cCurr = c;
        for (String cmd : move) {
            int rBefore = rCurr;
            int cBefore = cCurr;
            switch (cmd) {
                case "go":
                    if (direction == Direction.NORTH || direction == Direction.SOUTH) {
                        rCurr = direction == Direction.NORTH ? rCurr - 1 : rCurr + 1;
                        if (canGo(office, rCurr, cCurr)) {
                            answer += clean(office, rCurr, cCurr);
                        } else {
                            rCurr = rBefore;
                        }
                    } else {
                        cCurr = direction == Direction.EAST ? cCurr + 1 : cCurr - 1;
                        if (canGo(office, rCurr, cCurr)) {
                            answer += clean(office, rCurr, cCurr);
                        } else {
                            cCurr = cBefore;
                        }
                    }
                    break;
                case "right":
                    direction = changeDirection(direction, true);
                    break;
                case "left":
                    direction = changeDirection(direction, false);
                    break;
            }
        }
        return answer;
    }

    public Direction changeDirection(Direction direction, boolean isRight) {
        if (isRight) {
            return Direction.fromInt((direction.value + 1) % 4);
        } else {
            return Direction.fromInt((direction.value + 3) % 4);
        }
    }

    public boolean canGo(int[][] office, int r, int c) {
        if (r >= office.length || r < 0) {
            return false;
        }
        if (c >= office.length || c < 0) {
            return false;
        }
        return office[r][c] != -1;
    }

    public int clean(int[][] office, int r, int c) {
        int dirt = office[r][c];
        office[r][c] = 0;
        return dirt;
    }
}
