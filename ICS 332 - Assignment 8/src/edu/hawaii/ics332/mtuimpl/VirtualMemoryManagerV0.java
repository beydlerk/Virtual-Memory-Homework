package edu.hawaii.ics332.mtuimpl;

/**
 *  Version V0 - Memory only
 *  VirtualMemoryManagerV0 (simulated) system uses only the main memory, addressing it via physical addresses
 *	
 *	@author Kevin Beydler
 * 	@date 4/20/17
 * 	@class ICS 332
 */

import java.util.*; //basic functions
import java.text.*; //text formatting
import java.io.*; //basic file writing/handling directives
import java.lang.*;
import edu.hawaii.ics332.controllers.MemoryTranslationUnit;
import edu.hawaii.ics332.computer.*;
import edu.hawaii.ics332.computer.tests.*;
import edu.hawaii.ics332.datatypes.*;
import edu.hawaii.ics332.exceptions.*;
import edu.hawaii.ics332.logging.*;
import edu.hawaii.ics332.mtuimpl.*;
import edu.hawaii.ics332.scenarios.*;

public class VirtualMemoryManagerV0 extends MemoryTranslationUnit {

	private int location;
	private byte value;
	
	/**
	 * @param memorySize the memory size in bytes. A power of 2, >= 2
	 * @param diskSize the disk size in bytes. A multiple of pageSize
	 * @param pageSize the page size in bytes
	 * @param locality unused
	 * @param out the name of the file where the {@link MemoryTranslationUnit#log(String)} messages are written to
	 * @throws ICS332MemoryException
	 * @throws ICS332IOException
	 */
	public VirtualMemoryManagerV0(
			Integer memorySize, 
			Integer diskSize, 
			Integer pageSize,
			Integer locality,
			String out) throws ICS332MemoryException, ICS332IOException {
		super("VirtualMemoryManagerV0", new MainMemory(memorySize), null, pageSize, locality, out);
	}


	/* (non-Javadoc)
	 * @see edu.hawaii.ics332.controllers.MemoryTranslationUnit#readByte(java.lang.Integer)
	 */
	@Override
	public Byte readByte(Integer address) throws ICS332MemoryException {
		// TODO Auto-generated method stub
		int c = 0;
		byte result;
		
		while(address != 0)
		{
		c = (byte)c++;
		address --;
		}
		result = (byte)c;
		return result;//read value
	}

	/* (non-Javadoc)
	 * @see edu.hawaii.ics332.controllers.MemoryTranslationUnit#writeByte(java.lang.Integer, java.lang.Byte)
	 */
	@Override
	public void writeByte(Integer address, Byte value) throws ICS332MemoryException {
		// TODO Auto-generated method stub
		while(address != 0){
		log("Write " + address + " at " + value);
		address --;
		}
	}

	/* (non-Javadoc)
	 * @see edu.hawaii.ics332.controllers.MemoryTranslationUnit#dumpMemoryContents()
	 */
	@Override
	public String dumpMemoryContents() {
		// TODO Auto-generated method stub
		String out;
		out = "Memory dump for VirtualMemoryManagerV0";
		
		return out;
	}

	/* (non-Javadoc)
	 * @see edu.hawaii.ics332.controllers.MemoryTranslationUnit#dumpDiskContents()
	 */
	@Override
	public String dumpDiskContents() throws ICS332Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.hawaii.ics332.controllers.MemoryTranslationUnit#writeBackAllPagesToDisk()
	 */
	@Override
	public void writeBackAllPagesToDisk() throws ICS332MemoryException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see edu.hawaii.ics332.controllers.MemoryTranslationUnit#getPageFaultCount()
	 */
	@Override
	public int getPageFaultCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see edu.hawaii.ics332.controllers.MemoryTranslationUnit#getTransferedByteCount()
	 */
	@Override
	public int getTransferedByteCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see edu.hawaii.ics332.controllers.MemoryTranslationUnit#getDiskSize()
	 */
	@Override
	public int getDiskSize() {
		// TODO Auto-generated method stub
		return this.memory.size();
	}

	/* (non-Javadoc)
	 * @see edu.hawaii.ics332.controllers.MemoryTranslationUnit#getLocality()
	 */
	@Override
	public int getLocality() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see edu.hawaii.ics332.controllers.MemoryTranslationUnit#zeroMemory()
	 */
	@Override
	public void zeroMemory() throws ICS332MemoryException {
		// TODO Auto-generated method stub
		byte memory = 0;
		log("Zeroing memory");
	}
	
	
	public void main(String[] args) throws ICS332MemoryException
	{		
		int location = 8;
		byte value = 8;
		
		
		
		getDiskSize();
		System.out.println("Zeroing memory");
		zeroMemory();
		System.out.println("Memory dump for VirtualMemoryManagerV0");
		//log("Memory dump for VirtualMemoryManagerV0");
		
		log(dumpMemoryContents());
		dumpMemoryContents();
		
		log("Read 16 at -0002");
		log("Read " + readByte(location) + " at " + value);
		//log("Write " + writeByte(mem, bit) + " at " + bit);
		writeByte(location, value);
		readByte(location);
		
		
		//zero memory
		//dump memory
		//write
		//read
		//dump memory
		closeOut();
	}
}
