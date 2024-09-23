import "./MainLayout.css";
import { Footer } from "../../Layout/Footer/Footer";
import { Header } from "../../Layout/Header/Header";
import { Menu } from "../../Layout/Menu/Menu";
import { MainRoute } from "../../Routes/MainRoute/MainRoute";
export function MainLayout(): JSX.Element {
    return (
        <div className="MainLayout">
			 <header>
                <Header />
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.css"></link>
            </header>
            <div style={{padding:10}}>
                <Menu />
            </div>
            <main>
            <script src="https://cdn.jsdelivr.net/npm/notyf@3/notyf.min.js"></script>
                <MainRoute />
            </main>
            <footer>
                <Footer />
            </footer>
        </div>
    );
}
