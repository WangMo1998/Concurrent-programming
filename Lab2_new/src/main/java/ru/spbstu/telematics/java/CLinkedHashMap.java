package ru.spbstu.telematics.java;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class CLinkedHashMap<K,V> implements Cloneable, Serializable, Iterable<CEntry<K,V>>{
	
	private CEntry<K,V> first;
	private int size;
	
	CLinkedHashMap(){
		this.first = null;
		this.size = 0;
	}
	
	/*
	 * 念徉怆屙桢 镟瘥 觌-珥圜屙桢 � 觐腚尻鲨�.
	 * 念徉怆�弪 耦玟囗睇� 钺牝 � 磬鬣腩 疋�珥钽� 耧桉赅.
	 */
	public V put(K key, V value){
		CEntry e = new CEntry(key, value);
		if(this.size == 0) {
			first = e;
			this.size++;
		}
		else {
			if(!this.contains(key)){
				e.next = first;
				first = e;
				size++;
			}
		}
		return value;
	}
	
	public boolean contains(K key){
		if(this.size == 0) return false;
		CEntry cur = first;
		int hash = key.hashCode();
		do{
			if(hash == cur.hash) return true;
			cur = cur.next;
		} while (cur != null);
		return false;
	}
	
	public V get(K key){
		if(this.size == 0) return null;
		CEntry cur = first;
		int hash = key.hashCode();
		do{
			if(hash == cur.hash) return (V) cur.value;
			cur = cur.next;
		} while (cur.next != null);
		return null;
	}
	
	public boolean remove(K key){
		if(this.size == 0) return false;
		CEntry cur = first;
		CEntry prev = null;
		int hash = key.hashCode();
		do{
			if(hash == cur.hash) {
				if(prev == null) first = first.next;
				else prev.next = cur.next;
				size--;
				return true;
			}
			prev = cur;
			cur = cur.next;
		} while (cur.next != null);
		return false;
	}
	
	public int size(){
		return size;
	}
	

	public Iterator<CEntry<K,V>> iterator(){
        return new Iterator<CEntry<K,V>>()
        {
            CEntry<K,V> cur = first;
            CEntry<K,V> prev = null;
            boolean isFirst = true;


            public boolean hasNext()
            {
                if(cur.next != null)
                    return true;
                else
                    return false;
            }

            public CEntry<K,V> next()
            {
                if(isFirst)
                {
                    isFirst = false;
                    return cur;
                }
                if(cur.next != null)
                {
                	prev = cur;
                    cur = cur.next;
                    return cur;
                }
                else
                    return null;
            }
            
            public void remove(){
            	if(isFirst)
                {
                    first = first.next;
                } else {
                	prev.next = cur.next;
                }
            }
        };
	}
}
