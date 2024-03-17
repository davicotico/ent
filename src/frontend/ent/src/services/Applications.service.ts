import { api } from 'src/boot/axios';
import { ApplicationResponseModel } from 'src/models/application.model';

class ApplicationService {
  async getApplications() {
    return await api.get<ApplicationResponseModel[]>('/applications');
  }
}

export default new ApplicationService();
