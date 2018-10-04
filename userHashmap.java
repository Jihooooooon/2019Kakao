public class userHashmap {

    // 데이터를 저장할 Entry는 값과 다음 Entry를 가진다.
    private class Entry{
        private int value;
        public Entry next;
    }

    private int size;
    private Entry[] hTable;

    // Hash Table은 size와 배열 테이블을 생성한다.
    public userHashmap(int size){

        this.size = size;
        this.hTable = new Entry[size];
    }

    // key 값으로 HashTable에 저장될 index를 반환한다.
    public int hashMethod(int key){
        return key % size;
    }

    // 저장할 데이터로 key를 추출한다.
    // 실제 Hash 에는 특별한 알고리즘이 적용되 hashCode를 얻는다.
    public int getKey(int data){
        return data;
    }

    // data를 HashTable에 저장한다.
    public int add(int data){

        // data의 hashCode를 key와 저장할 index를 얻는다.
        int key = getKey(data);
        int hashValue = hashMethod(key);

        // 저장할 Entry 생성
        Entry entry = new Entry();
        entry.value = data;


        // HashTable의 저장할 index가 비어있다면,  저장하고 끝낸다.
        if(hTable[hashValue] == null){

            hTable[hashValue] = entry;
            return 0;
        }


        Entry pre = null;
        Entry cur = hTable[hashValue];

        // 해당 index의 연결리스트는 값의 크기가 작은 값부터 큰 순서로 정렬되어있다.
        while(true){

            if(cur == null){     // Hash Table에 저장할 index가 비어있으면

                hTable[hashValue] =entry;  // 해당 index에 저장
                return 0;

            }else if(cur.value < key){    // 해당 index의 커서 노드의 값이 key보다 작으면

                // 커서를 하나 뒤로 옮긴다.
                pre = cur;
                cur = cur.next;

            }else{     // 해당 index의 커서 노드의 값이 key 보다 크다.(여기에 저장)

                // 커서 노드가 HashTable의 첫번째 노드이면
                if(cur == hTable[hashValue]){

                    // 삽입 노드를 첫번째 노드로 삽입하고 다음 노드를 커서노드로 지정한다.
                    entry.next = cur;
                    hTable[hashValue]= entry;
                    return 0;

                }else{    // 첫번째 노드가 아니면

                    // 삽입 노드의 다음 노드로 커서노드를 지정하고
                    // 전 노드의 다음 노드를 삽입노드로 지정한다.
                    entry.next = cur;
                    pre.next = entry;
                    return 0;
                }
            }
        }
    }


    // data가 있는 위치를 얻는다.
    public int get(int data){

        int key = getKey(data);
        int hashValue = hashMethod(key);

        // data가 있는 index의 첫번째 노드를 얻는다.
        Entry cur = hTable[hashValue];

        while(true){

            if(cur == null){    // index 가 비어있다면 -1 반환

                return -1;

            }else if(cur.value == key){    // 커서의 값과 키가 같으면 0 반환

                return hashValue;

            }else if(cur.value > key){    // 커서의 값이 키보다 크면 -1 반환
                // 리스트는 작은 값에서 큰 값으로 정렬되어있다.
                return -1;

            }else{        // 커서의 값이 키보다 작으면 다음 노드로 커서 이동

                cur = cur.next;
            }

        }
    }

    // data가 있는 노드를 반환한다.
    private Entry getEntry(int data){

        int key = getKey(data);
        int hashValue = hashMethod(key);

        // HashTable의 index의  첫번째 노드와 두번째 노드
        Entry pre = hTable[hashValue];
        Entry cur = pre.next;

        while(true){

            if(cur == null){    // 커서 노드가 null 이면 null 반환

                return null;

            }else if(cur.value == key){    // 커서 노드의 값이 키와 같으면 전 노드를 반환

                return pre;

            }else if(cur.value > key){    // 커서의 값이 키보다 크면 null 반환

                return null;

            }else{            // 커서의 값이 키보다 작으면 커서를 다음으로 이동

                pre = cur;
                cur = cur.next;
            }
        }
    }

    // data 를 제거
    public int remove(int data){

        Entry pre = null;

        // data가 있는 노드의 전노드를 가져오고 null이면 -1 반환
        if((pre=getEntry(data))== null){
            return -1;
        }

        // 전 노드가 data의 다음노드를 가리키게 한다.
        // data 노드를 건너뛰게 연결한다 (제거)
        Entry cur = pre.next;
        pre.next = cur.next;
        return 0;
    }

    public String toString(){

        StringBuffer result = new StringBuffer();
        Entry cur = null;

        for(int i=0; i<size; i++){

            result.append("[" + i + "]\t");
            cur = hTable[i];

            if(cur == null){
                result.append("n ");

            }else{

                while(cur!=null){
                    result.append(cur.value + "");
                    cur = cur.next;
                }
            }
            result.append("\n");
        }

        return result.toString();
    }
}
