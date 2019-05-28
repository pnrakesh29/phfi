package com.smh.util;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.smh.model.PHFIFeatureRequest;

public class MapUtil
{
 
  /**Method for sort the map accoring to list size
   * @param orig
   * @return
   */
  public static Map<Long, List<PHFIFeatureRequest>> mySortedMap(final Map<Long, List<PHFIFeatureRequest>> orig)
  {
      final Comparator<Long> c = new Comparator<Long>()
      {
          public int compare(final Long o1, final Long o2)
          {
              // Compare the size of the lists. If they are the same, compare
              // the keys themsevles.
              final int sizeCompare = orig.get(o2).size() - orig.get(o1).size();
              return sizeCompare != 0 ? sizeCompare : o1.compareTo(o2);
            //  return sizeCompare != 0 ? o1.compareTo(o2) :sizeCompare;
          }
      };

      final Map<Long, List<PHFIFeatureRequest>> ret = new TreeMap<Long, List<PHFIFeatureRequest>>(c);
      ret.putAll(orig);
      return ret;
  }

}
