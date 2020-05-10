package iducs.java.lombok;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class LombokModel {
	 private @NonNull String groupid;
	 private @NonNull String artifactid;
	 private @NonNull String version;

}
