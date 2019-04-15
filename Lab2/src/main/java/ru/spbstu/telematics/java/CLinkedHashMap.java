package ru.spbstu.telematics.java;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class CLinkedHashMap<K,V> implements Cloneable, Serializable{
	
	private CEntry<K,V> first;
	private int size;
	
	CLinkedHashMap(){
		this.first = null;
		this.size = 0;
	}
	
	/*
	 * §¥§à§Ò§Ñ§Ó§Ý§Ö§ß§Ú§Ö §á§Ñ§â§í §Ü§Ý§ð§é-§Ù§ß§Ñ§é§Ö§ß§Ú§Ö §Ó §Ü§à§Ý§Ý§Ö§Ü§è§Ú§ð.
	 * §¥§à§Ò§Ñ§Ó§Ý§ñ§Ö§ä §ã§à§Ù§Õ§Ñ§ß§ß§í§Û §à§Ò§ì§Ö§Ü§ä §Ó §ß§Ñ§é§Ñ§Ý§à §ã§Ó§ñ§Ù§ß§à§Ô§à §ã§á§Ú§ã§Ü§Ñ.
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
}
