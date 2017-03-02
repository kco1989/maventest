package com.kco.game.maze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by pc on 2017/3/2.
 */
public abstract class AbstractMazeBuilder {
    public static final int MAX_ROW_LINE = 200;
    protected int row;
    protected int line;
    protected Box[][] boxes;
    protected int[][] solverPath;
    protected boolean isSolver;
    protected List<MazePoint> bestPath;
    protected Random random;

    public AbstractMazeBuilder(int row, int line){
        if (row < 3 || row > MAX_ROW_LINE || line < 3 || line > MAX_ROW_LINE){
            throw new IllegalArgumentException("row/line 必须大于3,小于" + MAX_ROW_LINE);
        }
        this.row = row;
        this.line = line;

        isSolver = false;
        boxes = new Box[row][line];
        solverPath = new int[row][line];
        bestPath = new ArrayList<MazePoint>();
        random = new Random();

        for (int i = 0; i < row; i ++){
            for (int j = 0; j < line; j ++){
                boxes[i][j] = new Box();
                solverPath[i][j] = Integer.MAX_VALUE;
            }
        }
    }
    protected abstract int find(MazePoint point);

    protected abstract void union(MazePoint point1, MazePoint point2);

    protected abstract boolean hasPath();

    public void makeMaze(){
        while (hasPath()){

            ThreeTuple<MazePoint, Position, MazePoint> tuple = findNextPoint();
            if (tuple == null){
                continue;
            }
            union(tuple.one, tuple.three);
            breakWall(tuple.one, tuple.two);
            breakWall(tuple.three, tuple.two.anotherSide());
        }
        breakWall(new MazePoint(0,0), Position.LEFT);
        breakWall(new MazePoint(row - 1, line - 1), Position.RIGHT);
    }

    private ThreeTuple<MazePoint, Position, MazePoint> findNextPoint() {
        MazePoint currentPoint = new MazePoint(random.nextInt(row), random.nextInt(line));
        Position position = Position.indexOf(random.nextInt(Position.values().length));
        MazePoint nextPoint = findNext(currentPoint, position);
        if (nextPoint == null || find(currentPoint) == find(nextPoint)){
            return null;
        }
        return new ThreeTuple<MazePoint, Position, MazePoint>(currentPoint, position, nextPoint);
    }

    private void breakWall(MazePoint point, Position position) {
        boxes[point.x][point.y].set(position, Wall.ACCESS);
    }

    private MazePoint findNext(MazePoint currentPoint, Position position) {
        MazePoint nextPoint;
        switch (position){
            case TOP:
                nextPoint = new MazePoint(currentPoint.x - 1, currentPoint.y);
                break;
            case RIGHT:
                nextPoint = new MazePoint(currentPoint.x, currentPoint.y + 1);
                break;
            case DOWN:
                nextPoint = new MazePoint(currentPoint.x + 1, currentPoint.y);
                break;
            case LEFT:
            default:
                nextPoint = new MazePoint(currentPoint.x, currentPoint.y - 1);
                break;
        }
        if (nextPoint.x < 0 || nextPoint.x >= row || nextPoint.y < 0 || nextPoint.y >= line){
            return null;
        }
        return nextPoint;
    }

    public Box getBoxes(int x, int y) {
        return boxes[x][y];
    }

    public int getRow() {
        return row;
    }

    public int getLine() {
        return line;
    }

    public List<MazePoint> solvePath(){
        if (isSolver){
            return bestPath;
        }
        bestPath = new ArrayList<MazePoint>();
        solverPath(new MazePoint(0, 0), 0);
        addPath(new MazePoint(row - 1, line - 1));
        Collections.reverse(bestPath);
        return bestPath;
    }

    private void addPath(MazePoint point) {
        bestPath.add(point);
        for (Position position :Position.values()){
            MazePoint next = findNext(point, position);
            if (next == null || getBoxes(point.x, point.y).get(position) == Wall.BLOCK){
                continue;
            }
            if (solverPath[point.x][point.y] - 1 == solverPath[next.x][next.y]){
                addPath(next);
                return;
            }
        }
    }

    private void solverPath(MazePoint point, int count) {
        if (solverPath[point.x][point.y] <= count){
            return;
        }
        solverPath[point.x][point.y] = count;
        for (Position position : Position.values()){
            MazePoint next = findNext(point, position);
            if (next == null || getBoxes(point.x, point.y).get(position) == Wall.BLOCK){
                continue;
            }
            solverPath(next, count + 1);
        }
    }

    public static class MazePoint{
        public final int x;
        public final int y;

        public MazePoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "MazePoint{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
