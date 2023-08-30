package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//상품저장소
@Repository
public class ItemRepository {
    private static final Map<Long, Item> store = new HashMap<>(); //static 사용 주의
    //item의 id의 타입이 Long이어서 맞춰줌
    private static long sequence = 0L; //static 사용
    public Item save(Item item) {   //public Item : 메서드가 호출되면 "Item" 유형의 값을 반환할 것임!을 의미
                                        //save(Item item) : 메서드의 이름은 save이고
                                            //이 save메서드는 "Item" 유형의 매개변수 "item"을 받아들이는 것을 의미
                                                //외부에서 "Item"객체를 전달하면 이 메서드(save)가 호출되어 처리됨
        item.setId(++sequence);
        store.put(item.getId(), item);
            //store.put(item.getId(), item) 코드는 store 변수가 HashMap의 객체를 참조
                //Map 인터페이스의 메서드 활용: HashMap은 Map 인터페이스의 메서드를 구현하고 있으며, 이 중 put 메서드는 키와 값의 쌍을 저장하는 기능을 수행
        return item;
        //결론
        //1. save메서드는 "Item"유형의 객체를 받아들여서 
        //2. 저장 작업을 수행
        //3. 저장한 후에는 동일한 "Item" 객체를 반환
        //4. 이 과정에서 메서드 내부에서 "setId"와 "store.put"작업을 수행하여 아이템을 저장하고 관리
    }
    public Item findById(Long id) {
        return store.get(id);
    }
    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }
    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }
    public void clearStore() {
        store.clear();
    }
}
