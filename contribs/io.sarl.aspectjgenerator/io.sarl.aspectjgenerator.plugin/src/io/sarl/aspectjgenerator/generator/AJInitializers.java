/*
 * $Id$
 *
 * SARL is an general-purpose agent programming language.
 * More details on http://www.sarl.io
 *
 * Copyright (C) 2014-2017 the original authors or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.sarl.aspectjgenerator.generator;

/** Initializer for AspectJ.
 * @author $Author: tpiotrow$
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
public final class AJInitializers {

	//private static final String FEATURE_NAME_PATTERN = "^.*\\.([a-zA-Z_$*]+)(?:\\(.*?\\))?$"; //$NON-NLS-1$

	//private static final Pattern FEATURE_NAME_PAT = Pattern.compile(FEATURE_NAME_PATTERN);

	//private static final String TYPE_NAME_PATTERN = "^.*[.$]([^.$]+)$"; //$NON-NLS-1$

	//private static final Pattern TYPE_NAME_PAT = Pattern.compile(TYPE_NAME_PATTERN);

	//private static final String TYPE_CONVERSION_FILENAME = "conversions/type_conversion.properties"; //$NON-NLS-1$

	//private static final String FEATURE_CONVERSION_FILENAME = "conversions/feature_name_conversion.properties"; //$NON-NLS-1$

	//	private AJInitializers() {
	//		//
	//	}

	//	private static List<Pair<String, String>> loadPropertyFile(String filename) {
	//		final URL url = FileLocator.find(
	//				AJGeneratorPlugin.getDefault().getBundle(),
	//				Path.fromPortableString(filename),
	//				null);
	//		final OrderedProperties properties = new OrderedProperties();
	//		try (InputStream is = url.openStream()) {
	//			properties.load(is);
	//		} catch (IOException exception) {
	//			AJGeneratorPlugin.getDefault().getLog().log(
	//					AJGeneratorPlugin.getDefault().createStatus(IStatus.ERROR, exception));
	//		}
	//		return properties.getOrderedProperties();
	//	}

	//	/** Replies the initializer for the type converter.
	//	 *
	//	 * @return the initializer.
	//	 */
	//	public static IExtraLanguageConversionInitializer getTypeConverterInitializer() {
	//		return it -> {
	//			final List<Pair<String, String>> properties = loadPropertyFile(TYPE_CONVERSION_FILENAME);
	//			if (!properties.isEmpty()) {
	//				for (final Pair<String, String> entry : properties) {
	//					final String source = Objects.toString(entry.getKey());
	//					final String target = Objects.toString(entry.getValue());
	//					final String baseName;
	//					final Matcher matcher = TYPE_NAME_PAT.matcher(source);
	//					if (matcher.find()) {
	//						baseName = matcher.group(1);
	//					} else {
	//						baseName = source;
	//					}
	//					it.apply(baseName, source, target);
	//				}
	//			}
	//		};
	//	}
	//
	//	/** Replies the initializer for the feature name converter.
	//	 *
	//	 * @return the initializer.
	//	 */
	//	public static IExtraLanguageConversionInitializer getFeatureNameConverterInitializer() {
	//		return it -> {
	//			final List<Pair<String, String>> properties = loadPropertyFile(FEATURE_CONVERSION_FILENAME);
	//			if (!properties.isEmpty()) {
	//				for (final Pair<String, String> entry : properties) {
	//					final String source = Objects.toString(entry.getKey());
	//					final String target = Objects.toString(entry.getValue());
	//					final Matcher matcher = FEATURE_NAME_PAT.matcher(source);
	//					final String featureName;
	//					if (matcher.find()) {
	//						featureName = matcher.group(1);
	//					} else {
	//						featureName = source;
	//					}
	//					it.apply(featureName, source, target);
	//				}
	//			}
	//		};
	//	}
	//
	//	/** Specific properties with reading order.
	//	 *
	//	 * @author $Author: sgalland$
	//	 * @version $FullVersion$
	//	 * @mavengroupid $GroupId$
	//	 * @mavenartifactid $ArtifactId$
	//	 * @since 0.6
	//	 */
	//	private static class OrderedProperties extends Properties {
	//
	//		private static final long serialVersionUID = 162949168401947298L;
	//
	//		private final List<Pair<String, String>> orderedElements = new ArrayList<>();
	//
	//		OrderedProperties() {
	//			//
	//		}
	//
	//		@Override
	//		public synchronized Object put(Object key, Object value) {
	//			this.orderedElements.add(new Pair<>(Objects.toString(key), Objects.toString(value)));
	//			return super.put(key, value);
	//		}
	//
	//		/** Replies the ordered elements.
	//		 *
	//		 * @return the ordered elements.
	//		 */
	//		public List<Pair<String, String>> getOrderedProperties() {
	//			return this.orderedElements;
	//		}
	//
	//	}

}
