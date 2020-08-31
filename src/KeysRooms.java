import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lixuefeng
 * @date 2020-08-31 19:42
 * @description:循环
 */
public class KeysRooms {
    Set<Integer> set=new HashSet<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        open(rooms,0);
        return set.size()==rooms.size();
    }
    private void open(List<List<Integer>> rooms, int index){
        if(set.contains(index)) return;
        set.add(index);
        for(int i:rooms.get(index)) open(rooms,i);
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        list.add(1);list.add(2);
        List<Integer> list1=new ArrayList<>();
        list1.add(1);list1.add(2);list1.add(2);
        List<Integer> list2=new ArrayList<>();
        list2.add(1);
        rooms.add(list);rooms.add(list1);rooms.add(list2);
        KeysRooms a=new KeysRooms();
        System.out.println(a.canVisitAllRooms(rooms));
    }
}
//[[1,2],[2,2,1],[1]]