package com.itrus.contract.demo.utils.profile;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public class ProfileUtil {

	public static final String PROFILE_ALIAS_KEY = "profile.alias";
	static final String PROFILE_ID_KEY = "profile.id";
	static final String PROFILE_CACHE_PATH = "temp/";
	static final String PROFILE_ID_SEPARATOR = "_";
	static final String PROFILE_CACHE_SUFFIX = ".txt";

	public static boolean cleanAll(String alias) {
		return deleteProfiles(alias);
	}

	public static void save(Properties profile) throws IOException {
		save(profile.getProperty(PROFILE_ALIAS_KEY), profile);
	}

	@SuppressWarnings("rawtypes")
	public static void save(String alias, Map props) throws IOException {
		File file = getProfileFile(alias);
		Properties profile;
		if (file.exists()) {
			profile = loadProfile(file);
		} else {
			profile = new Properties();
			profile.put(PROFILE_ALIAS_KEY, alias);
		}

		OutputStream outputStream = new FileOutputStream(file);
		Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
		for (Object key : props.keySet()) {
			profile.put(String.valueOf(key), String.valueOf(props.get(key)));
		}
		profile.store(writer, "ESP User Profile for API Demo");
		writer.flush();
		writer.close();
		outputStream.close();
	}

	public static Properties findByAliasAndId(String alias)
			throws IOException {
		return loadProfile(getProfileFile(alias));
	}

	public static Properties findByAlias(String alias) {
		File[] profiles = getUserProfileCachePath().listFiles(new ProfileFinder(alias, null));
		if (profiles == null || profiles.length < 1) {
			return null;
		}
		File profile = profiles[0];
		if (profiles.length > 1) {
			System.out.println("[WARN] Find multiple profiles " + Arrays.toString(profiles) + ". Use " + profile);
		}
		try {
			return loadProfile(profile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Properties findById(String id) throws IOException {
		File[] profiles = getUserProfileCachePath().listFiles(new ProfileFinder(null, id));
		if (profiles == null || profiles.length < 1) {
			return null;
		}
		return loadProfile(profiles[0]);
	}

	static File getUserProfileCachePath() {
		File profileCachePath = new File(PROFILE_CACHE_PATH);
		if (!profileCachePath.exists()) {
			System.out.println("[INFO] create user profile cache path " + profileCachePath.getAbsolutePath());
			if (!profileCachePath.mkdirs()) {
				System.err.println("[ERROR] create user profile cache path failed.");
				System.exit(0x0002);
			}
		}
		return profileCachePath;
	}

	public static File getProfileFile(String alias) {
		return new File(getUserProfileCachePath(), alias + PROFILE_CACHE_SUFFIX);
	}

	public static Properties loadProfile(File file) throws IOException {
		Properties profile = null;
		if (file.exists()) {
			profile = new Properties();
			InputStream inputStream = new FileInputStream(file);
			Reader reader = new InputStreamReader(inputStream, "UTF-8");
			profile.load(reader);
			reader.close();
			inputStream.close();
		}
		return profile;
	}

	static boolean deleteProfiles(final String profileName) {
		boolean isOk = true;
		File[] userProfiles = getUserProfileCachePath().listFiles(new ProfileFinder(profileName, null));
		if (userProfiles != null) {
			for (File userProfile : userProfiles) {
				if (!userProfile.delete()) {
					System.err.println("[ERR] delete user profile " + userProfile + " cache failed.");
					isOk = false;
				}
			}
		}
		return isOk;
	}

	static class ProfileFinder implements FileFilter {
		private final String alias;
		private final String id;

		public ProfileFinder(String alias, String id) {
			this.alias = alias;
			this.id = id;
		}

		@Override
		public boolean accept(File file) {
			boolean matched = file.isFile();
			if (alias != null) {
				matched &= file.getName().startsWith(alias);
			}
			if (id != null) {
				matched &= file.getName().endsWith(PROFILE_ID_SEPARATOR + id + PROFILE_CACHE_SUFFIX);
			}
			return matched;
		}
	}
}
