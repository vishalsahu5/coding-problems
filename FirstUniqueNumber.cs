public class FirstUnique
{

  private Dictionary<int, LinkedListNode<int>> map;
  private LinkedList<int> list;


  public FirstUnique(int[] nums)
  {
    map = new Dictionary<int, LinkedListNode<int>>();
    list = new LinkedList<int>();
    for (int i = 0; i < nums.Length; i++)
    {
      Add(nums[i]);
    }
  }

  public int ShowFirstUnique()
  {
    if (list.Count == 0) return -1;
    return list.First.Value;
  }

  public void Add(int value)
  {
    if (map.ContainsKey(value))
    {
      if (map[value] != null)
      {
        list.Remove(map[value]);
        map[value] = null;
      }
    }
    else
    {
      var node = list.AddLast(value);
      map.Add(value, node);
    }
  }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.ShowFirstUnique();
 * obj.Add(value);
 */
