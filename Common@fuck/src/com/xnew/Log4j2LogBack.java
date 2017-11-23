package com.xnew;

import java.lang.reflect.Field;
import java.util.Enumeration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.SLF4JLocationAwareLog;
import org.apache.commons.logging.impl.SLF4JLog;
import org.apache.log4j.Appender;
import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.HierarchyEventListener;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.RepositorySelector;
import org.slf4j.spi.LocationAwareLogger;

public class Log4j2LogBack {

	
	private static class LoggerEx extends Logger implements Log
	{
		Log log2;
		private transient LocationAwareLogger logger;
		private static final String FQCN = LoggerEx.class.getName();
		
		public LoggerEx(String name) {
			super(name);
			Log	log = LogFactory.getLog(name);
			log2 = log;
			if(log instanceof SLF4JLocationAwareLog)
			{
				try {
					Field f = SLF4JLocationAwareLog.class.getDeclaredField("logger");
					f.setAccessible(true);
					this.logger = (LocationAwareLogger) f.get(log);
					
				} catch (Exception e) {
					
					e.printStackTrace();
				} 
				
			}
			
			
		}
		@Override
		public void trace(Object message) {
			logger.log(null, FQCN, LocationAwareLogger.TRACE_INT, String.valueOf(message), null, null);
		}
		@Override
		public void trace(Object message, Throwable t) {
			 this.logger.log(null, FQCN, LocationAwareLogger.TRACE_INT, String.valueOf(message), null, t);
		}
		@Override
		public boolean isTraceEnabled() {
			return logger.isTraceEnabled();
		}
		@Override
		public void debug(Object message) {
			logger.log(null, FQCN, LocationAwareLogger.DEBUG_INT, String.valueOf(message), null, null);
		}
		@Override
		public void debug(Object message, Throwable t) {
			 this.logger.log(null, FQCN, LocationAwareLogger.DEBUG_INT, String.valueOf(message), null, t);
		}
		@Override
		public void error(Object message) {
			logger.log(null, FQCN, LocationAwareLogger.ERROR_INT, String.valueOf(message), null, null);
		}
		@Override
		public void error(Object message, Throwable t) {
			 this.logger.log(null, FQCN, LocationAwareLogger.ERROR_INT, String.valueOf(message), null, t);
		}
		@Override
		public void fatal(Object message) {
			logger.log(null, FQCN, LocationAwareLogger.ERROR_INT, String.valueOf(message), null, null);
		}
		@Override
		public void fatal(Object message, Throwable t) {
			 this.logger.log(null, FQCN, LocationAwareLogger.ERROR_INT, String.valueOf(message), null, t);
		}
		@Override
		public void info(Object message) {
			logger.log(null, FQCN, LocationAwareLogger.INFO_INT, String.valueOf(message), null, null);
		}
		@Override
		public void info(Object message, Throwable t) {
			 this.logger.log(null, FQCN, LocationAwareLogger.INFO_INT, String.valueOf(message), null, t);
		}
		@Override
		public boolean isDebugEnabled() {
			// TODO Auto-generated method stub
			return logger.isDebugEnabled();
		}
		@Override
		public boolean isInfoEnabled() {
	
			return logger.isInfoEnabled();
		}
		@Override
		public void warn(Object message) {
			logger.log(null, FQCN, LocationAwareLogger.WARN_INT, String.valueOf(message), null, null);
		}
		@Override
		public void warn(Object message, Throwable t) {
			 this.logger.log(null, FQCN, LocationAwareLogger.WARN_INT, String.valueOf(message), null, t);
		}
		@Override
		public boolean isErrorEnabled() {
			// TODO Auto-generated method stub
			return log2.isErrorEnabled();
		}
		@Override
		public boolean isFatalEnabled() {
			// TODO Auto-generated method stub
			return log2.isFatalEnabled();
		}
		@Override
		public boolean isWarnEnabled() {
			// TODO Auto-generated method stub
			return log2.isWarnEnabled();
		}
		
		
		
		
	}
	
	
	private static class LoggerRepositoryEx implements LoggerRepository
	{

		@Override
		public void addHierarchyEventListener(
				HierarchyEventListener paramHierarchyEventListener) {			
		}

		@Override
		public boolean isDisabled(int paramInt) {
			return false;
		}

		@Override
		public void setThreshold(Level paramLevel) {

			
		}

		@Override
		public void setThreshold(String paramString) {
	
			
		}

		@Override
		public void emitNoAppenderWarning(Category paramCategory) {
	
			
		}

		@Override
		public Level getThreshold() {
		
			return null;
		}

		@Override
		public Logger getLogger(String paramString) {

			return new LoggerEx(paramString);
		}

		@Override
		public Logger getLogger(String paramString,
				LoggerFactory paramLoggerFactory) {
			
			return new LoggerEx(paramString);
		}

		@Override
		public Logger getRootLogger() {
		
			return new LoggerEx("");
		}

		@Override
		public Logger exists(String paramString) {
			
			return null;
		}

		@Override
		public void shutdown() {
		}

		@Override
		public Enumeration getCurrentLoggers() {
			return null;
		}

		@Override
		public Enumeration getCurrentCategories() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void fireAddAppenderEvent(Category paramCategory,
				Appender paramAppender) {
		
		}

		@Override
		public void resetConfiguration() {
		
		}
		
	}
	
	
	
	public static void ChangeLog4j2LogBack()
	{
		
		try
		{
			
			Class.forName(LogManager.class.getName());
			Class<?> c = LogManager.class;
			Field f = c.getDeclaredField("repositorySelector");
			f.setAccessible(true);
			final LoggerRepositoryEx ffff = new LoggerRepositoryEx();
			RepositorySelector rs = new RepositorySelector() {
				
				@Override
				public LoggerRepository getLoggerRepository() {
					return ffff;
				}
			};
			f.set(null, rs);
					
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	
}
