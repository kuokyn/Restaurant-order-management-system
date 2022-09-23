public class InternetOrder implements Order{
    protected int size;
    protected ListNode head;
    protected ListNode tail;

    public InternetOrder(int count) {
        head = new ListNode();
        size = 1;
        head.next = tail;
        tail.next = head;
    }

    public InternetOrder(Item[] items) {
        for (Item i:items)
        {
            this.add(i);
        }
    }

    @Override
    public void add(Item item) {
        if (head.value == null){
            head = new ListNode(null,item);
        }
        else{
            ListNode current = head;
            while(current.next!=null && current.next!=head)
                current = current.next;
            ListNode newNode = new ListNode(head,item);
            tail = newNode;
            current.next = newNode;
            size++;
        }
    }

    @Override
    public boolean deleteThis(String item) {
        boolean isDeleted = false;
        ListNode current  = head;
        ListNode chosen = null;
        while(current.next!=head){
            if (current.value.getName()==item){
                chosen = current;
                isDeleted = true;
            }
            current=current.next;
        }
        if (chosen==head){
            tail.next=head.next;
            head=chosen.next;
            size--;
        }
        else{
            if (chosen==tail){
                ListNode previous = head;
                while(previous.next!=tail)
                    previous = previous.next;
                previous.next = head;
                tail = previous;
                size--;
            }
            else{
                ListNode previous = head;
                current = head.next;
                while(current.next!=head){
                    if (current == chosen){
                        previous.next = current.next;
                        size--;
                    }
                    previous = current;
                    current = current.next;
                }

            }
        }
        return isDeleted;
    }

    @Override
    public Item[] getItems() {
        Item[] items = new Item[size];
        ListNode current = head;
        int i=0;
        do{
            items[i] = current.value;
            current = current.next;
            i++;
        } while(current.next!=head);
        return items;
    }

    @Override
    public double getTotalCost() {
        double totalCost = 0;
        ListNode current = head;
        do{
            totalCost+=current.value.getCost();
            current = current.next;
        } while(current.next!=head);
        return totalCost;
    }

    @Override
    public int getItemsCount(String itemName) {
        ListNode current = head;
        int count = 0;
        do{
            if(current.value.getName()==itemName)
                count++;
            current = current.next;
        } while(current.next!=head);
        return count;
    }

    @Override
    public Item[] getItemSort() {
        Item[] items = new Item[size];
        ListNode current = head;
        for (int i=0;i<size;i++){
            items[i]=current.value;
            current = current.next;
        }
        for (int i=0;i<size-1;i++){
            for (int j=i+1;j<size;j++){
                if(items[i].getCost()<items[j].getCost()){
                    Item temp = items[i];
                    items[i] = items[j];
                    items[j] = temp;
                }
            }
        }
        return items;
    }

}
