import axios from 'axios';
import icone from '../../assets/img/notification-icon.svg'
import { BASE_URL } from '../../utils/request';
import './styles.css'


type Props = {

    saleId: number;

}

function handleClick(id:number){
    axios.get(`${BASE_URL}/sales/${id}/notification`).then(res => {
        console.log("SUCESSO");
    })
}

function NotificationButton({saleId} : Props) {
    return (
        <div className="dsmeta-red-btn" onClick={()=>handleClick(saleId)}>
            <img src={icone} alt="Notificar" />
        </div>
    )
}

export default NotificationButton
