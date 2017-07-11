package pl.karolcyprowski.simple.srs.dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import pl.karolcyprowski.simple.srs.dictionary.entities.DictionaryItem;
import pl.karolcyprowski.simple.srs.dictionary.entities.Langcode;
import pl.karolcyprowski.simple.srs.dictionary.service.DictionaryService;

public class DictionaryCreatorImpl implements DictionaryCreator {
	
	@Autowired
	private DictionaryService dictionaryService;
	
	static Logger logger = Logger.getLogger(DictionaryCreatorImpl.class);
	
	public boolean isDictionaryEmpty()
	{
		return true;
	}
	
	public void createDictionaryFromCSV(File file)
	{
		List<DictionaryItem> items = dictionaryService.getAllItems();
		if(items.isEmpty())
		{
			populateDictionary();
		}
	}
	
	private void populateDictionary()
	{
		List<Langcode> langcodes = dictionaryService.getLangcodes();
		File file = new File("src/main/webapp/resources/csv/zzz.csv");
		String csvSplitBy = ",";
		String line = "";
		try{
			BufferedReader bf = new BufferedReader(new FileReader(file));
			while((line = bf.readLine()) != null) 
			{
				String[] wordlist = line.split(csvSplitBy);
				int id = 0;
				for(int i = 0; i < wordlist.length; i++)
				{
					String word = wordlist[i].trim();
					if(i == 0)
					{
						id = Integer.parseInt(word);
					}
					else
					{
						DictionaryItem item = new DictionaryItem(id, word, langcodes.get(i-1).getLangcode());
						dictionaryService.addItem(item);
						logger.info("Card added: " + item.getWord() + " with id " + item.getId() + " to " + item.getLangcode());
					}
				}
			}
			bf.close();
		}catch(FileNotFoundException e){
			logger.warn(e);
//			assertEquals(true, false);
		}catch(IOException e){
			logger.warn(e);
//			assertEquals(true, false);
		}
	}

}
