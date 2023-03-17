package Homework6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class App {
  public static void main(String[] args) {
    var mg1 = new MapGenerator();
    int[][] map1 = mg1.getMap();
    var mg2 = new MapGenerator();
    int[][] map2 = mg2.getMap();
    System.out.println(
        new MapPrinter().rawData(map1));

    var lee = new WaveAlgorithm(map1);
    Point2D startPoint = new Point2D(5, 7);
    lee.Colorize(startPoint);

    System.out.println(
        new MapPrinter().rawData(map1));

    Point2D endPoint = new Point2D(10, 10);
    ArrayList<Point2D> road = lee.getRoad(startPoint, endPoint);

    var lee2 = new WaveAlgorithm(map2);
    mg2.setCat(startPoint);
    mg2.setExit(endPoint);
    lee2.setPath(road);

    // красиво выводим лабиринт с маршрутом от старта (^) до выхода (E)
    System.out.println(
        new MapPrinter().mapColor(
            mg2.getMap()));

  }

}

class Point2D {
  int x, y;

  public Point2D(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public String toString() {
    return String.format("x: %d  y: %d", x, y);
  }
}

class MapGenerator {
  int[][] map;

  public MapGenerator() {
    int[][] map = {
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, 00, -1, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, -1, -1, -1, -1, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, -1, 00, 00, -1, 00, 00, 00, 00, -1 },
        { -1, -1, -1, 00, -1, 00, -1, 00, 00, -1, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, -1, 00, 00, -1, -1, -1, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, -1, -1, -1, -1, -1, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, -1, -1, -1, -1, -1, -1, 00, 00, 00, -1 },
        { -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
    };

    this.map = map;
  }

  public int[][] getMap() {
    return map;
  }

  public void setCat(Point2D pos) {
    map[pos.x][pos.y] = -2;
  }

  public void setExit(Point2D pos) {
    map[pos.x][pos.y] = -3;
  }
}

class MapPrinter {

  public MapPrinter() {
  }

  public String rawData(int[][] map) {
    StringBuilder sb = new StringBuilder();

    for (int row = 0; row < map.length; row++) {
      for (int col = 0; col < map[row].length; col++) {
        sb.append(String.format("%5d", map[row][col]));
      }
      sb.append("\n");
    }
    for (int i = 0; i < 3; i++) {
      sb.append("\n");
    }

    return sb.toString();
  }

  public String mapColor(int[][] map) {
    StringBuilder sb = new StringBuilder();

    for (int row = 0; row < map.length; row++) {
      for (int col = 0; col < map[row].length; col++) {
        switch (map[row][col]) {
          case 0:
            sb.append(" ");
            break;
          case -1:
            sb.append("*");
            break;
          case -2:
            sb.append("^");
            break;
          case -3:
            sb.append("E");
            break;
          case -4:
            sb.append("#");
            break;
          default:
            break;
        }
      }
      sb.append("\n");
    }
    for (int i = 0; i < 3; i++) {
      sb.append("\n");
    }
    return sb.toString();
  }
}

class WaveAlgorithm {
  int[][] map;

  public WaveAlgorithm(int[][] map) {
    this.map = map;
  }

  public void Colorize(Point2D startPoint) {
    Queue<Point2D> queue = new LinkedList<Point2D>();
    queue.add(startPoint);
    map[startPoint.x][startPoint.y] = 1;

    while (queue.size() != 0) {
      Point2D p = queue.remove();

      if (map[p.x - 1][p.y] == 0) {
        queue.add(new Point2D(p.x - 1, p.y));
        map[p.x - 1][p.y] = map[p.x][p.y] + 1;
      }
      if (map[p.x][p.y - 1] == 0) {
        queue.add(new Point2D(p.x, p.y - 1));
        map[p.x][p.y - 1] = map[p.x][p.y] + 1;
      }
      if (map[p.x + 1][p.y] == 0) {
        queue.add(new Point2D(p.x + 1, p.y));
        map[p.x + 1][p.y] = map[p.x][p.y] + 1;
      }
      if (map[p.x][p.y + 1] == 0) {
        queue.add(new Point2D(p.x, p.y + 1));
        map[p.x][p.y + 1] = map[p.x][p.y] + 1;
      }
    }
  }

  public ArrayList<Point2D> getRoad(Point2D start, Point2D exit) {
    ArrayList<Point2D> road = new ArrayList<>();
    ///
    // ЕСЛИ финишная ячейка помечена
    Point2D currentPoint = exit;
    // ТО
    // перейти в финишную ячейку
    road.add(currentPoint);
    int currX = currentPoint.getX();
    int currY = currentPoint.getY();
    // ЦИКЛ
    // выбрать среди соседних ячейку, помеченную числом на 1 меньше числа в текущей
    // ячейке
    // перейти в выбранную ячейку и добавить её к пути
    while (!((currX == start.getX()) && (currY == start.getY()))) {
      if (map[currX][currY] - map[currX - 1][currY] == 1) {
        road.add(new Point2D(currX - 1, currY));
        currX--;
        continue;
      }
      if (map[currX][currY] - map[currX][currY - 1] == 1) {
        road.add(new Point2D(currX, currY - 1));
        currY--;
        continue;
      }
      if (map[currX][currY] - map[currX + 1][currY] == 1) {
        road.add(new Point2D(currX + 1, currY));
        currX++;
        continue;
      }
      if (map[currX][currY] - map[currX][currY + 1] == 1) {
        road.add(new Point2D(currX, currY + 1));
        currY++;
        continue;
      }
    }
    return road;
  }

  public void setPath(ArrayList<Point2D> path) {
    for (int i = 1; i < path.size() - 1; i++) {
      map[path.get(i).x][path.get(i).y] = -4;
    }
  }

}
