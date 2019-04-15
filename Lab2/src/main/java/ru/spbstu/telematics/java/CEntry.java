package ru.spbstu.telematics.java;

public class CEntry<K,V> {
	public K key;
	public V value;
	public int hash;
	public CEntry<K,V> next;
	
	CEntry(){
		this.next = null;
	}
	
	CEntry(K key, V value){
		this.key = key;
		this.value = value;
		this.next = null;
		this.hash = key.hashCode();
	}
}
