package com.artisan.java8;

import java.util.Objects;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/***************************************
 * @author:Alex Wang
 * @Date:2016/11/3 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class SpliteratorInAction {

    private static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam in lacinia massa, quis eleifend dui. Sed in molestie ex. Curabitur id dui orci. Aenean pulvinar, tortor et egestas semper, mauris lectus malesuada ex, quis commodo urna nulla vitae eros. Cras scelerisque vel ligula at suscipit. Maecenas non ipsum quis est malesuada lobortis. Cras porta tortor elit, ut dictum ipsum pellentesque in. Mauris ut sollicitudin tellus.\n" +
            "\n" +
            "Integer dictum, erat ut interdum viverra, erat dui suscipit eros, eget vestibulum mi massa ut sem. Donec ultrices arcu eget massa lobortis fringilla. Nam ac neque in ex aliquet dictum vitae a augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris sed dui dictum, tincidunt ligula at, blandit augue. Aenean tincidunt magna elit. Cras odio risus, sodales vel lacus scelerisque, tempus vestibulum justo. Ut quis malesuada arcu, vel convallis nulla. Phasellus at tincidunt sem. Curabitur a vehicula metus. Curabitur ullamcorper, odio sed consectetur faucibus, orci est semper ante, ac semper sapien tortor sed leo. Fusce vel dignissim enim. Proin ac lectus non est venenatis malesuada. Sed rutrum, eros vitae dictum rhoncus, velit diam lacinia eros, vitae tristique felis ligula eget tellus. Quisque porttitor, dolor quis porta malesuada, turpis purus vestibulum mi, quis tempus lectus tortor id arcu. Vivamus varius egestas elit in hendrerit.\n" +
            "\n" +
            "Quisque lacinia non enim venenatis efficitur. Duis luctus at ex at ullamcorper. Fusce maximus sapien a scelerisque euismod. Quisque sapien mauris, malesuada at nibh eget, euismod dignissim diam. Nulla auctor eros ac massa pretium, sed elementum lorem maximus. Quisque eleifend elit eu lectus molestie cursus. Suspendisse tempus fringilla semper. Morbi luctus, leo in tincidunt venenatis, tortor elit gravida nisi, ac facilisis est purus in felis. Vestibulum vel volutpat ante. Nunc in finibus lorem, eu iaculis augue. In rhoncus, ex ac suscipit bibendum, magna lorem pellentesque est, id lacinia erat tortor et neque. Nunc porttitor massa at vehicula dictum. Aliquam interdum, tortor sed dictum posuere, risus justo rutrum nisl, vel luctus ex est ac sapien. Praesent cursus, nulla ac pretium tincidunt, orci arcu gravida metus, ac blandit neque mi non nisi. Aliquam dapibus eros nec metus vestibulum egestas ac feugiat elit. Donec ut condimentum nunc.\n" +
            "\n" +
            "Morbi eu congue ipsum, ac lobortis nulla. Proin cursus tortor lectus, nec luctus lectus ornare a. Mauris gravida nisl et eros congue fermentum. Donec lorem augue, sagittis sed nisl viverra, congue euismod tortor. Sed orci velit, imperdiet eu nulla rhoncus, porttitor laoreet enim. Morbi vitae aliquet lorem. Suspendisse tristique scelerisque consequat. Ut vel nulla tristique, accumsan nulla vulputate, gravida orci. Maecenas justo ex, aliquam ac gravida eu, sagittis semper nunc. Aliquam posuere augue ut est fringilla, tristique vulputate felis volutpat. Suspendisse quis ex nec mauris commodo auctor ac nec orci. Maecenas porta iaculis libero, eu lacinia eros ultrices eu. Morbi cursus sem euismod odio convallis dapibus. Nulla in mi interdum, semper sem vel, varius felis. Curabitur tincidunt eleifend leo, eget tempus mi ultricies vitae. Cras a turpis viverra, suscipit quam ut, porta turpis.\n" +
            "\n" +
            "Phasellus scelerisque aliquam eros vel malesuada. Morbi tristique eleifend hendrerit. Phasellus metus tortor, bibendum a lectus vel, facilisis vestibulum libero. Cras eu augue volutpat, iaculis purus et, vehicula lorem. Cras augue mauris, fermentum euismod eros at, molestie tincidunt odio. Proin pretium maximus tortor eget dignissim. Duis tincidunt pretium felis. Vestibulum non mollis risus, sit amet lacinia arcu. Sed elementum urna felis, a tincidunt odio pharetra convallis. Quisque laoreet risus sit amet tristique porttitor. Sed accumsan venenatis justo non dapibus. Suspendisse ac est erat.\n" +
            "\n" +
            "Sed luctus lacus ut porta ornare. Suspendisse pretium sed nibh ac ultricies. Praesent feugiat congue facilisis. Fusce tempus ligula nibh, a laoreet sapien vehicula at. Integer sed fermentum quam. Interdum et malesuada fames ac ante ipsum primis in faucibus. Proin id magna nisl. Vestibulum a eros nisi. Curabitur feugiat nisl nisl, et aliquam orci feugiat vel. Ut sit amet arcu elit. Cras id nisl in nibh euismod pharetra.\n" +
            "\n" +
            "Vivamus interdum aliquet massa nec pharetra. Praesent facilisis ante id justo consequat, et convallis diam vestibulum. Integer in tincidunt ex. Aenean tempor tempus odio, a iaculis massa. Nulla in neque sed enim pharetra ultrices. Vestibulum in tristique nisl, dignissim condimentum urna. Nam sed metus massa. Nam lacinia vel arcu vel tincidunt. Etiam euismod sed lectus vel suscipit. Sed nec dui mauris. Praesent aliquam enim orci. Cras molestie elit id metus iaculis pharetra. Vestibulum cursus tellus vitae molestie posuere. Phasellus elementum justo id elit consectetur tempor.\n" +
            "\n" +
            "Quisque diam mi, mollis sed metus pharetra, porttitor pulvinar ante. Sed faucibus pretium metus, in convallis leo rhoncus pulvinar. Suspendisse vitae nisi lacinia, varius mi non, faucibus nunc. Integer ut ante feugiat, mollis ligula non, scelerisque erat. Praesent tristique enim sit amet dui euismod venenatis sed id turpis. Sed porta malesuada ligula in faucibus. Proin semper semper est a egestas.\n" +
            "\n" +
            "Sed in enim non lorem laoreet posuere nec consequat tortor. Nunc mattis ut lectus id egestas. Ut consequat libero et nunc blandit elementum. Duis dui lectus, hendrerit id justo quis, condimentum maximus felis. Fusce sed elit ut magna mollis laoreet in non orci. Nunc est lacus, volutpat vitae scelerisque nec, luctus eget erat. Fusce vestibulum, odio at consectetur commodo, quam nunc vehicula ligula, eget sollicitudin tortor leo id neque. Quisque rhoncus maximus enim quis tempor. Sed varius posuere purus, vitae interdum est sagittis sed. Sed aliquam, nisl at gravida tempor, erat massa posuere augue, nec consectetur nunc arcu nec lectus. Pellentesque rhoncus feugiat urna, eu gravida mauris dictum in. In volutpat sem sapien. Donec in erat ligula. Nam a turpis neque. Sed quis tempor orci. Quisque in lectus eget libero scelerisque maximus.\n" +
            "\n" +
            "Curabitur convallis risus nec sapien eleifend lacinia. Curabitur cursus enim est, a pretium elit fringilla eget. Cras nec nunc a magna vulputate facilisis ac nec nunc. Nullam imperdiet finibus urna ac pretium. Quisque at porta dolor. Sed pretium ac urna ut ornare. In tempus vel turpis quis hendrerit. Vivamus sit amet quam et velit suscipit tincidunt. Nulla quis tincidunt dui. Sed hendrerit, purus non iaculis vulputate, metus augue venenatis justo, a hendrerit orci neque vitae elit. Suspendisse quis posuere magna, id venenatis mi. Nunc ac laoreet nisl. Integer faucibus euismod enim, a mattis odio cursus placerat. Maecenas non nulla pulvinar, efficitur ex sed, dictum nibh.\n" +
            "\n" +
            "Nam orci arcu, tincidunt quis eros vitae, venenatis vehicula dui. Nunc vitae nisl mauris. Fusce eu ornare ex, sit amet tempus eros. Mauris sit amet odio quis quam eleifend luctus. Sed hendrerit tortor quis augue ullamcorper, et congue erat tincidunt. Curabitur rhoncus magna at faucibus finibus. Curabitur in molestie metus, non varius sem. Vivamus pellentesque eleifend sapien sed interdum. Nulla et lacus a mi pellentesque facilisis nec at metus. Aliquam aliquam diam ut sapien tincidunt ornare. Mauris id tortor rutrum ligula rutrum commodo quis nec eros. Integer porttitor velit quam, at pretium eros dignissim quis. Sed felis nunc, sodales ac ligula quis, viverra posuere tellus. Duis finibus non ligula a bibendum. Proin non ultrices velit. Maecenas suscipit purus at ultricies ultricies.\n" +
            "\n" +
            "Vestibulum mollis consectetur arcu id cursus. Ut non laoreet diam. Maecenas dapibus quam sit amet condimentum porta. Suspendisse vulputate metus sapien, ac consectetur sapien euismod eleifend. Duis at ornare est. Donec nibh diam, faucibus nec urna id, rhoncus hendrerit est. Pellentesque non dignissim ex. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Ut eu tellus sit amet sapien dictum varius. Nunc sit amet velit enim. Integer sit amet massa orci. Integer vel leo id risus pellentesque egestas. Nunc felis urna, scelerisque ac purus sit amet, cursus ornare ante.\n" +
            "\n" +
            "In porta faucibus suscipit. Proin a commodo felis. Sed rutrum nisl nibh. Vestibulum sollicitudin ex nec sem eleifend pharetra at vel nisi. Fusce maximus magna erat. Curabitur laoreet sem eget semper eleifend. Suspendisse ut nisi dolor. Vestibulum rhoncus quam id nisl vestibulum, sed mollis enim pellentesque. Donec scelerisque justo eu risus venenatis semper. Nam vitae porttitor justo.\n" +
            "\n" +
            "Fusce a sagittis lorem. Nam congue odio ut auctor venenatis. Aliquam erat volutpat. In ultrices leo tincidunt mi fringilla facilisis. Cras molestie enim ut commodo pulvinar. In blandit tempor neque, et pretium sapien congue sed. Ut consectetur in leo non mollis. Aenean ultricies odio sem, at pharetra sapien vestibulum eget. Nulla ut tristique massa. Sed in dapibus nulla. Fusce a lectus sed libero viverra venenatis. Quisque condimentum massa vitae neque pharetra, quis convallis quam scelerisque. In quam elit, laoreet et pellentesque ut, faucibus at est. Suspendisse faucibus tincidunt justo, eget mollis odio lobortis id.\n" +
            "\n" +
            "Maecenas dictum arcu nec nisi sollicitudin, vel varius odio ornare. Nunc venenatis neque bibendum fringilla consectetur. Curabitur arcu ante, volutpat non volutpat nec, lobortis et est. Praesent porta lacus et nisi blandit porttitor. Maecenas nisl sapien, lobortis sit amet dictum ut, ultrices ac risus. Nullam id augue tincidunt, sollicitudin nibh sit amet, finibus nulla. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Cras laoreet sed nunc eget luctus. Praesent nec venenatis libero, eget convallis ante. Maecenas tincidunt fringilla elit, sed dapibus quam dignissim ac. Nunc quis efficitur orci. Pellentesque id mi finibus est ullamcorper tincidunt. Donec tincidunt lorem id condimentum interdum. In luctus enim eget lacinia auctor.";


    public static void main(String[] args) {
        MySpliteratorText mySpliteratorText = new MySpliteratorText(text);
        Optional.ofNullable(mySpliteratorText.parallelStream().count())
                .ifPresent(System.out::println);

       // mySpliteratorText.stream().forEach(System.out::println);

        mySpliteratorText.parallelStream().filter(s -> !s.equals("")).forEach(System.out::println);

        IntStream intStream = IntStream.rangeClosed(0, 100);
        intStream
                .parallel()
                .filter(null)
                .sequential()
                .map(null)
                .parallel()
                .forEach(null);

    }

    /**
     * ResultSet
     * T
     * s getString("")
     * t.set()
     *
     * Object
     * List<Object></Object>
     */
    static class MySpliteratorText {

        private final String[] data;

        public MySpliteratorText(String text) {
            Objects.requireNonNull(text, "The parameter can not be null");
            this.data = text.split("\n");
        }

        public Stream<String> stream() {
            return StreamSupport.stream(new MySpliterator(), false);
        }

        public Stream<String> parallelStream() {
            return StreamSupport.stream(new MySpliterator(), true);
        }

        private class MySpliterator implements Spliterator<String> {

            private int start, end;

            public MySpliterator() {
                this.start = 0;
                this.end = MySpliteratorText.this.data.length - 1;
            }

            public MySpliterator(int start, int end) {
                this.start = start;
                this.end = end;
            }

            @Override
            public boolean tryAdvance(Consumer<? super String> action) {
                if (start <= end) {
                    action.accept(MySpliteratorText.this.data[start++]);
                    return true;
                }
                return false;
            }

            @Override
            public Spliterator<String> trySplit() {
                int mid = (end - start) / 2;
                if (mid <= 1) {
                    return null;
                }

                int left = start;
                int right = start + mid;
                start = start + mid + 1;
                return new MySpliterator(left, right);
            }

            @Override
            public long estimateSize() {
                return end - start;
            }

            @Override
            public long getExactSizeIfKnown() {
                return estimateSize();
            }

            @Override
            public int characteristics() {
                return IMMUTABLE | SIZED | SUBSIZED;
            }
        }
    }
}
