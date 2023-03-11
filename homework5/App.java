package Homework5;
public class App {
    public static void main(String[] args) {
      var map = getMap();
      // System.out.println(rawData(getMap()));
      System.out.println(mapColor(getMap()));
    }
  
    static int[][] getMap() {
      return new int[][] {
          { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
          { -1, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
          { -1, 00, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
          { -1, 00, 00, 00, -1, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
          { -1, 00, 00, 00, -1, 00, -1, -1, -1, -1, 00, 00, 00, 00, -1, 00, -1, -1, -1, 00, 00, 00, 00, -1 },
          { -1, 00, 00, 00, -1, 00, -1, 00, 00, -1, 00, 00, 00, 00, -1, 00, -1, 00, 00, 00, 00, 00, 00, -1 },
          { -1, -1, -1, 00, -1, 00, -1, 00, 00, -1, 00, 00, 00, 00, -1, 00, -1, 00, 00, 00, 00, 00, 00, -1 },
          { -1, 00, 00, 00, -1, 00, -1, 00, 00, -1, -1, -1, 00, 00, -1, 00, -1, 00, 00, 00, 00, 00, 00, -1 },
          { -1, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
          { -1, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
          { -1, 00, 00, 00, -1, -1, -1, -1, -1, -1, 00, 00, 00, 00, -1, -1, -1, -1, -1, 00, 00, 00, 00, -1 },
          { -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
          { -1, 00, 00, 00, -1, -1, -1, -1, -1, -1, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
          { -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
          { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
      };
    }
  
    static String rawData(int[][] map) {
      StringBuilder sb = new StringBuilder();
  
      for (int row = 0; row < map.length; row++) {
        for (int col = 0; col < map[row].length; col++) {
          sb.append(String.format("%5d", map[row][col]));
        }
        sb.append("\n");
      }
  
      return sb.toString();
    }
  
    static String mapColor(int[][] map) {
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
              sb.append("Р");
              break;
            case -3:
              sb.append("E");
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
  
  // 1. Р“РµРЅРµСЂР°С‚РѕСЂ РєР°СЂС‚
  // 2. РџСЂРёРЅС‚РµСЂ РєР°СЂС‚
  // 3. ...